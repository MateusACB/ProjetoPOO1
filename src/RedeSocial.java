import java.util.ArrayList;
import java.util.Scanner;

public class RedeSocial {
    private ArrayList<Perfil> perfis;
    private int quantPerfis;

    public RedeSocial() {
        perfis = new ArrayList<>();
        quantPerfis = 0;
    }

    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();
        redeSocial.menuRedeSocial();
    }

    void menuRedeSocial() {
        Scanner scan = new Scanner(System.in);
        String opcao;
        do {
            System.out.println();
            System.out.println("Seja bem vindo(a)!");
            System.out.println("Digite 'C' para cadastrar-se, 'E' para entrar ou 'F' para fechar");
            opcao = scan.next();
            if (opcao.equalsIgnoreCase("C")) {
                cadastrarPerfil();
            } else if (opcao.equalsIgnoreCase("E")) {
                fazerLogin();
            }
        } while (!opcao.equalsIgnoreCase("F"));
        System.out.println("Programa encerrado");
    }

    void cadastrarPerfil() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do perfil: ");
        String nome = scan.nextLine();
        if (nome.equals("")) {
            System.out.println("O nome do perfil não pode ser vazio");
            return;
        }
        System.out.println("Digite o login do perfil: ");
        String login = scan.nextLine();
        if (login.equals("")) {
            System.out.println("O login do perfil não pode ser vazio");
            return;
        }
        for (int i = 0; i < quantPerfis; i++) {
            if (perfis.get(i).getLogin().equalsIgnoreCase(login)) {
                System.out.println("Esse login já está sendo utilizado");
                return;
            }
        }
        System.out.println("Digite a senha do perfil: ");
        String senha = scan.nextLine();
        if (senha.equals("")) {
            System.out.println("A senha do perfil não pode ser vazia");
        } else {
            Perfil perfil = new Perfil(nome,login,senha);
            System.out.println("Login cadastrado com sucesso!");
            perfis.add(perfil);
            quantPerfis++;
        }
    }

    void fazerLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o login: ");
        String loginX = scan.nextLine();
        System.out.println("Digite a senha:");
        String senhaX = scan.nextLine();

        for (int i = 0; i < quantPerfis; i++) {
            if (perfis.get(i).getLogin().equalsIgnoreCase(loginX)) {
                if (perfis.get(i).getSenha().equals(senhaX)) {
                    System.out.println("Login aprovado");
                    menuPerfil(i);
                } else {
                    System.out.println("Senha incorreta");
                }
            }
        }
        System.out.println("Login não encontrado");
    }

    void menuPerfil(int i) {
        Scanner scan = new Scanner(System.in);
        String opcao;
        System.out.println();
        System.out.println("Bem-vindo(a), " + perfis.get(i).getNome() + "!");
        do {
            System.out.println();
            System.out.println("Digite 'P' para postar, 'T' para visualizar a sua timeline ou 'S' para sair");
            opcao = scan.next();
            if (opcao.equalsIgnoreCase("P")) {
                System.out.println("Digite o texto: ");
                String a = scan.nextLine();
                String texto = scan.nextLine();

                perfis.get(i).postar(texto);
            } else if (opcao.equalsIgnoreCase("T")) {
                perfis.get(i).imprimirPerfil();
            }
        } while (!opcao.equalsIgnoreCase("S"));
        System.out.println("Até logo, " + perfis.get(i).getNome() + "!");
        menuRedeSocial();
    }
}
