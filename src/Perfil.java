import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Perfil {
    private String nome;
    private String login;
    private String senha;
    private ArrayList<Post> posts = new ArrayList<>();
    private int quantPosts = 0;

    public Perfil(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public void postar(String texto){
        Post p = new Post(texto);
        p.setData(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        p.setHora(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        p.setTexto(texto);
        System.out.println();
        System.out.println("Post enviado com sucesso!");
        this.posts.add(p);
        quantPosts++;
    }
    public void imprimirPerfil(){
        System.out.println();
        System.out.println("Timeline de: " + nome);
        System.out.println("Login: " + login);
        System.out.println("Posts:");
        for (int i = 0; i < this.quantPosts; i++) {
            posts.get(i).imprimirPost();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
