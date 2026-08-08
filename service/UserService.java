package SistemaDeCadastro.service;

import SistemaDeCadastro.model.User;
import java.util.List;
import static SistemaDeCadastro.repository.UserRepository.usuarios;

public class UserService
{
    public void salvar(String nome, String gmail, int idade)
    {
        User user = new User(nome, gmail, idade);
        usuarios.add(user);
    }

    public List<User> obterUsuarios() {
        return usuarios;
    }
}