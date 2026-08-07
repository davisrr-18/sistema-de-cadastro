package SistemaDeCadastro.service;

import SistemaDeCadastro.model.Usuario;
import java.util.List;
import static SistemaDeCadastro.repository.Lista.usuarios;

public class UsuarioServico
{
    public void salvar(String nome, String gmail, int idade)
    {
        Usuario user = new Usuario(nome, gmail, idade);
        usuarios.add(user);
    }

    public List<Usuario> obterUsuarios() {
        return usuarios;
    }
}