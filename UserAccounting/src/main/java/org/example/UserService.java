package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.JDBCConnection.getConnection;
import static org.example.SQLConstants.*;

public class UserService implements ServiceInterface {
    @Override
    public void createUser(String username, String password) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("User created.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                System.out.println("No user with this ID found.");
            } else {
                System.out.println("User deleted.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editUser(int id, String username, String password) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);
            if (preparedStatement.executeUpdate() == 0) {
                System.out.println("No user with this ID found.");
            } else {
                System.out.println("User edited.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAllUsers() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username") + "\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getUserById(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username") + "\n");
            } else {
                System.out.println("No user with this ID found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
