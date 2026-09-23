package view;

import java.util.Scanner;

public class ChooseOption
{
    Scanner scanner = new Scanner(System.in);
    public int option;

    public void chooseOption()
    {
        System.out.print("\nWhich option do you want to use: ");
        option = scanner.nextInt();
        scanner.nextLine();
    }
}