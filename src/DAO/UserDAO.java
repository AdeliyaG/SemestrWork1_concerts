package DAO;

import models.User;

import java.sql.*;


public class UserDAO {
    private static Connection connection = DBConnection.getConnection();


    public boolean loginIsContained(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, login);
            if (statement.executeQuery().next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Exception during loginIsContained");
            throw new IllegalArgumentException();
        }
        return false;
    }

    public void saveUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, firstname, lastname, password) VALUES (?, ?, ?, ?);");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getLastname());
//            statement.setString(4, user.getBirthLocalDate().toString());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveUser");
            throw new IllegalArgumentException();
        }
    }

    public boolean checkUser(String username, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            if (statement.executeQuery().next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Exception during checkUser");
            throw new IllegalArgumentException();
        }
        return false;
    }
}
