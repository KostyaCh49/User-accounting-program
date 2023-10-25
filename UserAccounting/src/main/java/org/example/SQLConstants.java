package org.example;

public class SQLConstants {
    public static final String CREATE_USER = "INSERT INTO users (username, password) VALUES (?, ?)";
    public static final String DELETE_USER = "DELETE FROM users WHERE id=?";
    public static final String EDIT_USER = "UPDATE users SET username=?, password=? WHERE ID=?";
    public static final String GET_ALL_USERS = "SELECT * FROM users";
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";
}
