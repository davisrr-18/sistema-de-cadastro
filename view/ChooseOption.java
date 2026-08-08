package SistemaDeCadastro.view;

import static SistemaDeCadastro.view.ScannerClass.scanner;

public class ChooseOption
{
    public int opcao;

    public void escolherOpcao()
    {
        System.out.print("\nQual opção desejar utilizar: ");
        opcao = scanner.nextInt();
        scanner.nextInt();
    }
}