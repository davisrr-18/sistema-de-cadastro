package RegistrationSystem.view;

import RegistrationSystem.model.User;
import RegistrationSystem.service.UserService;

import static RegistrationSystem.view.ScannerClass.scanner;

public class Main {

    static void main(String[] args) {

        UserService userService = new UserService();
        ChooseOption option = new ChooseOption();

        do {
            Menu.showMenu();
            option.chooseOption();

            switch (option.option) {

                case 1:
                    System.out.println("\n===== Registration =====");
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    userService.save(name, email, age);
                    System.out.println("User registered successfully!\n");
                    break;

                case 2:
                    System.out.println("\n===================================================================");
                    System.out.printf("%-20s | %-30s | %-5s%n", "NAME", "EMAIL", "AGE");
                    System.out.println("===================================================================");

                    for (User user : userService.getUsers()) {
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
    }
}