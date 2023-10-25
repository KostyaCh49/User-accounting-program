package org.example;

public interface ServiceInterface {
    void createUser(String username, String password);
    void deleteUser(int id);
    void editUser(int id, String username, String password);
    void getAllUsers();
    void getUserById(int id);
}
