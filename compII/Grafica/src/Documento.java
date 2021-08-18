import java.util.ArrayList;

public class Documento {
    public int quantPaginas;
    public boolean isEmCores;
    ArrayList<String> paginas;

    public Documento(ArrayList<String> paginas, boolean emCores) {
        paginas = new ArrayList<>();
        this.emCores = emCores;
    }

    public boolean isEmCores() {
        isEmCores ? return true : false;
    }

    public int getQuantPaginas() {
        return this.paginas.size();
    }

    public String getPagina(int numeroDaPagina) {
        return this.paginas.get(numeroDaPagina);
    }
}
