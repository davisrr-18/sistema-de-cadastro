package SistemaDeCadastro.view;

import SistemaDeCadastro.model.Usuario;
import SistemaDeCadastro.service.UsuarioServico;

import static SistemaDeCadastro.view.LeitorTeclado.scanner;

public class SistemaDeCadastro {

    static void main(String[] args) {

        UsuarioServico usuarioServico = new UsuarioServico();
        EscolherOpcao opcao = new EscolherOpcao();

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

                    for (Usuario user : usuarioServico.obterUsuarios()) {
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