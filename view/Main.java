package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import repository.UserRepository.UserData;
import service.UserService;

public class Main {

    private static final String TABLE_LINE =
            "===========================================================================";

    private record UserInput(String name, String email, int age) { }

    static void main(String[] args) 
    {

        try (Scanner scanner = new Scanner(System.in)) 
        {
            UserService userService = new UserService();
            ChooseOption option = new ChooseOption(scanner);
            Menu menu = new Menu();

            do 
            {
                menu.showMenu();
                option.chooseOption();

                switch (option.option) 
                {
                    case 1 -> 
                    {
                        System.out.println("\n===== Registration =====");
                        UserInput input = readUserInput(scanner);

                        if (userService.registerUser(input.name(), input.email(), input.age()))
                        {
                            System.out.println("User registered successfully!\n");
                        }

                        else 
                        {
                            System.out.println("User not registered! Age must be between 0 and 120.\n");
                        }
                    }

                    case 2 -> printUsersTable(userService.getAllUsers());

                    case 3 -> 
                    {
                        System.out.println("\n===== Update User =====");
                        int id = readInt(scanner, "Enter the user ID: ");
                        UserInput input = readUserInput(scanner);

                        if (userService.updateUser(id, input.name(), input.email(), input.age()))
                        {
                            System.out.println("User updated successfully!\n");
                        }

                        else 
                        {
                            System.out.println("User not updated! User not found or invalid age.\n");
                        }
                    }

                    case 4 -> 
                    {
                        System.out.println("\n===== Delete User =====");
                        int id = readInt(scanner, "Enter the user ID: ");

                        System.out.print("Are you sure you want to delete this user? (y/n): ");
                        String confirmation = scanner.nextLine().trim();

                        if (!confirmation.equalsIgnoreCase("y"))
                        {
                            System.out.println("Deletion cancelled.\n");
                        }

                        else if (userService.deleteUser(id))
                        {
                            System.out.println("User deleted successfully!\n");
                        }

                        else 
                        {
                            System.out.println("User not found.\n");
                        }
                    }

                    case 5 -> 
                    {
                        System.out.println("\n===== Search Users =====");
                        System.out.print("Enter the name (or part of it): ");
                        String term = scanner.nextLine();

                        printUsersTable(userService.searchUsersByName(term));
                    }

                    case 6 -> System.out.println("\nClosing system...");
                    default -> System.out.println("\nInvalid option. Try again.");
                }

            } while (option.option != 6);
        }
    }

    private static UserInput readUserInput(Scanner scanner)
    {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        int age = readInt(scanner, "Enter the age: ");

        return new UserInput(name, email, age);
    }

    private static int readInt(Scanner scanner, String prompt)
    {
        while (true)
        {
            System.out.print(prompt);

            try
            {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            catch (InputMismatchException e)
            {
                scanner.nextLine();
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void printUsersTable(List<UserData> users)
    {
        System.out.println("\n" + TABLE_LINE);
        System.out.printf("%-5s | %-20s | %-30s | %-5s%n", "ID", "NAME", "EMAIL", "AGE");
        System.out.println(TABLE_LINE);

        if (users.isEmpty())
        {
            System.out.println("No users found.");
        }

        for (UserData user : users) 
        {
            System.out.printf("%-5d | %-20s | %-30s | %-5d%n", user.id(), user.name(), user.email(), user.age());
        }

        System.out.println(TABLE_LINE + "\n");
    }
}
