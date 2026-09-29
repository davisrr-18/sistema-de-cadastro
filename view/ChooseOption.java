package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseOption
{
    private final Scanner scanner;
    public int option;

    public ChooseOption(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public void chooseOption()
    {
        System.out.print("\nWhich option do you want to use: ");

        try
        {
            option = scanner.nextInt();
        }

        catch (InputMismatchException e)
        {
            option = -1;
        }

        scanner.nextLine();
    }
}
