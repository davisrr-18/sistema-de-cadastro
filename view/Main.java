package RegistrationSystem.view;

import RegistrationSystem.model.User;
import RegistrationSystem.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        ChooseOption option = new ChooseOption();
        Menu menu = new Menu();

        do {
            menu.showMenu();
            option.chooseOption();

            switch (option.option) {

                case 1:
                    try
                    {
                        System.out.println("\n===== Registration =====");
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter your age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        if (userService.ageValidate(age))
                        {
                            userService.registerUser(name, email, age);
                            System.out.println("User registered successfully!\n");
                        }

                        else
                        {
                            System.out.println("User not registered!\n");
                        }
                    }

                    catch (InputMismatchException e)
                    {
                        System.out.println("Please enter a valid username and/or age.\n");
                        scanner.nextLine();
                    }

                    catch (Exception e)
                    {
                        System.out.println("An unexpected error occurred. Please try again.\n");
                        scanner.nextLine();
                    }

                    break;

                case 2:
                    System.out.println("\n===================================================================");
                    System.out.printf("%-20s | %-30s | %-5s%n", "NAME", "EMAIL", "AGE");
                    System.out.println("===================================================================");

                    for (User user : userService.getAllUsers()) {
                        System.out.printf("%-20s | %-30s | %-5d%n", user.getName(), user.getEmail(), user.getAge());
                    }

                    System.out.println("===================================================================");
                    break;

                case 3:
                    System.out.println("\nClosing system...");
                    break;

                default:
                    System.out.println("\nInvalid option. Try again.");
                    break;
            }

        } while (option.option != 3);

        scanner.close();
    }
}