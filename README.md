# Sistema de Cadastro

Sistema de cadastro de usuários em modo console, feito em Java 26 puro (sem frameworks).
Os dados ficam em memória enquanto o programa está em execução.

## Funcionalidades

| Opção | Ação |
|-------|------|
| 1 | Cadastrar usuário (nome, email e idade) |
| 2 | Listar todos os usuários |
| 3 | Atualizar um usuário pelo ID |
| 4 | Deletar um usuário pelo ID (com confirmação `y/n`) |
| 5 | Pesquisar usuários pelo nome (busca parcial, sem diferenciar maiúsculas/minúsculas) |
| 6 | Sair |

Regras:

- Cada usuário recebe um ID numérico auto-incremental. IDs de usuários deletados não são reutilizados.
- A idade precisa estar entre 0 e 120 no cadastro e na atualização.
- Entradas inválidas (letras no lugar de números) não encerram o programa: o menu mostra "Invalid option" e os campos numéricos são solicitados novamente.

## Arquitetura

O projeto é organizado em camadas, cada uma com uma responsabilidade:

```
model/        User.java             Record com os dados do usuário (id, name, email, age)
repository/   UserRepository.java   Armazenamento em memória (ArrayList) e geração de IDs
service/      UserService.java      Regras de negócio e validações
view/         Main.java             Loop principal e interação com o usuário
              Menu.java             Exibição do menu
              ChooseOption.java     Leitura da opção escolhida
```

Fluxo: `view` chama `service`, que chama `repository`. A `view` recebe apenas `UserRepository.UserData`,
nunca a entidade `User` diretamente.

## Como executar

Requisito: JDK 26 ou superior.

```bash
javac -d out model/*.java repository/*.java service/*.java view/*.java
java -cp out view.Main
```
