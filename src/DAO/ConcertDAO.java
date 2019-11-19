package DAO;

import models.Concerts;

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
                concerts.add(new Concerts(resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("poster"), resultSet.getDate("date").toLocalDate(), resultSet.getInt("place_id"), resultSet.getInt("rec_age"), resultSet.getInt("performer_id")));
            }
        } catch (SQLException e) {
            System.out.println("Exception during get concerts");
            throw new IllegalArgumentException();
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
                concerts.add(new Concerts(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("poster"),resultSet.getDate(4   ).toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all concerts sorted by date");
            throw new IllegalArgumentException(e);
        }
        return concerts;
    }

    public ArrayList<Concerts> getConcertsByLateDate() {
        ArrayList<Concerts> concerts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, poster, DATE_FORMAT(`date`,'%y.%m.%d') from concerts ORDER BY `date` desc");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                concerts.add(new Concerts(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("poster"), resultSet.getDate("date").toLocalDate()));
            }

        } catch (SQLException e) {
            System.out.println("Exception during find all video by videoname");
            throw new IllegalArgumentException();
        }
        return concerts;
    }
}
