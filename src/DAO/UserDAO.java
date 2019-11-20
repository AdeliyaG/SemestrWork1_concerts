package DAO;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
            e.printStackTrace(System.err);
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

    public User getUserByUsername(String username){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("password"), resultSet.getString("avatar"));
            }
        } catch (SQLException e) {
            System.out.println("Exception during get user by email");
            throw new IllegalArgumentException();
        }
        return null;
    }

    public void updateData(String firstname, String lastname, String avatar, String password, String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET firstname = ?, lastname = ?, avatar = ?, password = ? WHERE username = ?");
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, avatar);
            statement.setString(4, password);
            statement.setString(5, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during update data");
            throw new IllegalArgumentException();
        }
    }

    public void updateDataWithoutPassword(String firstname, String lastname, String avatar, String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET firstname = ?, lastname = ?, avatar = ? WHERE username = ?");
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, avatar);
            statement.setString(4, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during update data without password");
            throw new IllegalArgumentException();
        }
    }
}
