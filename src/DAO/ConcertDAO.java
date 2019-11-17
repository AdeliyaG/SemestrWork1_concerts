package DAO;

import models.Concerts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConcertDAO {
    private static Connection connection = DBConnection.getConnection();

    public ArrayList<Concerts> getConcerts() {
        ArrayList<Concerts> concerts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM concerts");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                concerts.add(new Concerts(resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("poster"), resultSet.getDate("date"), resultSet.getInt("place_id"), resultSet.getInt("rec_age"), resultSet.getInt("performer_id")));
            }
        } catch (SQLException e) {
            System.out.println("Exception during get concerts");
            throw new IllegalArgumentException();
        }
        return concerts;
    }
}
