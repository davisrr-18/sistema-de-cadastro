package SistemaDeCadastro.view;

import SistemaDeCadastro.model.User;
import SistemaDeCadastro.service.UserService;

import static SistemaDeCadastro.view.ScannerClass.scanner;

public class Main {

    static void main(String[] args) {

        UserService usuarioServico = new UserService();
        ChooseOption opcao = new ChooseOption();

        do {
            opcao.escolherOpcao();

            switch (opcao.opcao) {

                case 1:
                    System.out.println("\n===== Cadastro =====");
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite seu gmail: ");
                    String gmail = scanner.nextLine();

                    System.out.print("Digite sua idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    usuarioServico.salvar(nome, gmail, idade);
                    System.out.println("✅ Usuário cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.println("\n===================================================================");
                    System.out.printf("%-20s | %-30s | %-5s%n", "NOME", "GMAIL", "IDADE");
                    System.out.println("===================================================================");

                    for (User user : usuarioServico.obterUsuarios()) {
                        System.out.printf("%-20s | %-30s | %-5d%n", user.getNome(), user.getGmail(), user.getIdade());
                    }

                    System.out.println("===================================================================");
                    break;

                case 3:
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }

        } while (opcao.opcao != 3);
    }
}