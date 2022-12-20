public class Post {
    private String data;
    private String hora;
    private String texto;

    public Post(String texto) {
        this.texto = texto;
    }

    public void imprimirPost(){
        System.out.println(data + " às " + hora + " - " + texto);
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
