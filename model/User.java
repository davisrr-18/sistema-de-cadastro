package SistemaDeCadastro.model;

public class User
{
    private String nome, gmail;
    private int idade;

    public User(String nome, String gmail, int idade)
    {
        this.nome = nome;
        this.gmail = gmail;
        this.idade = idade;
    }

    public String getNome()
    {
        return nome;
    }
    public String getGmail()
    {
        return gmail;
    }
    public int getIdade()
    {
        return idade;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setGmail(String gmail)
    {
        this.gmail = gmail;
    }
    public void setIdade(int idade)
    {
        this.idade = idade;
    }
}