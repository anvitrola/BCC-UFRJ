import java.util.ArrayList;

public class Grafica {
    public float precoPorPaginaColorida;
    public float precoPorPaginaPB;
    protected ArrayList<Impressora> impressoras;
    protected revezamento;

    public Grafica (){
        impressoras = new ArrayList<>();
    }

    protected void imprimirDocumento(Documento documento) {
        if (revezamento == impressoras.size()) //zerar a ordem
            revezamento = 0;
        impressoras.get(revezamento).imprimirDocumento(documento);
        revezamento++;
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
