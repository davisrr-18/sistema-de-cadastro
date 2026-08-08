package RegistrationSystem.view;

import static RegistrationSystem.view.ScannerClass.scanner;

public class ChooseOption
{
    public int option;

    public void chooseOption()
    {
        System.out.print("\nWhich option do you want to use: ");
        option = scanner.nextInt();
        scanner.nextLine();
    }
}