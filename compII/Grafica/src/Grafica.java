import java.util.HashMap;
import java.util.Random;

public class Grafica {
    public float precoPorPaginaColorida;
    public float precoPorPaginaPB;
    protected HashMap<Integer, Impressora> impressoras;

    public Grafica (){
        impressoras = new HashMap<Integer, Impressora>();
    }

    protected void imprimirDocumento(Documento documento) {
            //ToDo
    }

    protected float orcarImpressao(Documento documento) {
        int numeroDePaginas = documento.getQuantPaginas();
        float orcamento;

        if(documento.isEmCores()){
            orcamento = numeroDePaginas * precoPorPaginaColorida;
        } else {
            orcamento = numeroDePaginas * precoPorPaginaPB;
        }

        return orcamento;
    }

    protected void adicionarImpressora(Impressora impressora) {
        impressoras.add(new Random(), impressora); //adiciona uma impressora com um código aleatório as index
    }

    protected void setPrecoPorPagina(float precoPorPagina, boolean emCores) {
        emCores ? precoPorPaginaColorida = precoPorPagina : precoPorPaginaPB = precoPorPagina
    }
}
