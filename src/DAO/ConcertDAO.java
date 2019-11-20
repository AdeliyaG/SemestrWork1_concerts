package DAO;

import models.Concerts;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ConcertDAO {
    private static Connection connection = DBConnection.getConnection();

    public ArrayList<Concerts> getConcerts() {
        ArrayList<Concerts> concerts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM concerts");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                concerts.add(new Concerts(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("poster"), resultSet.getDate("date").toLocalDate(), resultSet.getInt("place_id"), resultSet.getInt("rec_age"), resultSet.getInt("performer_id")));
            }
        } catch (SQLException e) {
            System.out.println("Exception during get concerts");
            throw new IllegalArgumentException(e);
        }
        return concerts;
    }

    public ArrayList<Concerts> getConcertsBySoonDate(String query) {
        ArrayList<Concerts> concerts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, poster, DATE_FORMAT(date,'%Y-%m-%d') from concerts WHERE title LIKE ? ORDER BY date asc");
            statement.setString(1, "%" + query + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                concerts.add(new Concerts(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("poster"), resultSet.getDate(4).toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all concerts sorted by date");
            throw new IllegalArgumentException(e);
        }
        return concerts;
    }

    public Concerts getConcertsByID(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT c.id,title,description,poster,date,p.address,p.name,perf.name,price,rec_age,c.performer_id from concerts c left outer join performers perf on c.performer_id = perf.id left outer join places p on c.place_id = p.id left outer join tickets on tickets.concert_id = c.id WHERE c.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Concerts(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("poster"), resultSet.getDate("date").toLocalDate(), resultSet.getInt("rec_age"), resultSet.getString(6), resultSet.getString("p.name"), resultSet.getInt("price"), resultSet.getInt("performer_id"), resultSet.getString("perf.name"));
            }
        } catch (SQLException e) {
            System.out.println("Exception during get concerts by id");
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    public boolean isUserStarredConcert(User user, Concerts concerts) {
        try {
            return check(user, concerts, connection.prepareStatement("SELECT user_id FROM user_starred_concert_rel WHERE user_id = ? AND concert_id = ?"));
        } catch (SQLException e) {
            return false;
        }
    }

    private boolean check(User user, Concerts concerts, PreparedStatement stmt) {
        try {
            PreparedStatement statement = stmt;
            statement.setInt(1, user.getId());
            statement.setInt(2, concerts.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            System.out.println("Exception during get concerts by id");
            throw new IllegalArgumentException(e);
        }
    }

    public boolean isUserBougthTicketForConcert(User user, Concerts concerts) {
        try {
            return check(user, concerts, connection.prepareStatement("SELECT user_id, c.id FROM user_ticket_rel utr LEFT outer JOIN tickets t ON t.id = utr.ticket_id LEFT OUTER JOIN concerts c ON t.concert_id = c.id WHERE user_id = ? AND t.concert_id = ?"));
        } catch (SQLException e) {
            return false;
        }
    }
}
