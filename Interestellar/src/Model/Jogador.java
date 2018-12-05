package Model;

public class Jogador {
    private int id;
    private String usuario;
    private String senha;
    private String email; 
    private String pontuacao;

    public Jogador()
    { }

    public int getId() {
        return id;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPontuacao() {
        return pontuacao;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }  
    
    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }     
}
