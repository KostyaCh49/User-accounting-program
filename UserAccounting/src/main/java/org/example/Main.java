package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("This is a user accounting program.\n");
        while (true) {
            System.out.print("""
                    Operations:
                    1. Create a new user
                    2. Delete the user
                    3. Edit user
                    4. Get all users
                    5. Get user by id
                    6. Quit
                    Select an operation(1-5):\s""");
            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1 -> createUser();
                case 2 -> deleteUser();
                case 3 -> editUser();
                case 4 -> userService.getAllUsers();
                case 5 -> {
                    System.out.print("Enter ID: ");
                    userService.getUserById(scanner.nextInt());
                }
                case 6 -> {
                    return;
                }
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter a username: ");
        String username = scanner.next();
        System.out.print("Enter a password: ");
        String password = scanner.next();
        userService.createUser(username, password);
        System.out.println();
    }

    private static void deleteUser() {
        System.out.print("Enter ID: ");
        userService.deleteUser(scanner.nextInt());
        System.out.println();
    }

    private static void editUser() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter a username: ");
        String username = scanner.next();
        System.out.print("Enter a password: ");
        String password = scanner.next();
        userService.editUser(id, username, password);
        System.out.println();
    }
}