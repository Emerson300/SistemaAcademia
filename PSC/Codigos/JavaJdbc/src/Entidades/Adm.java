package Entidades;

/**
 *
 * @author josemar
 */
public class Adm {
    private String nome,senha, login;
    private int id;

    public Adm() {
        
    }

    public Adm(String nome, String senha, String login, int id) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    

   
    
    
}
