import java.util.HashMap;

public class Grafica {
    public float precoPorPaginaColorida;
    public float precoPorPaginaPB;
    protected HashMap<Integer, Impressora> impressoras;

    public Grafica (){
        impressoras = new HashMap<Integer, Impressora>();
    }

    protected void imprimirDocumento(Documento documento) {
        // ToDo IMPLEMENT ME!!!
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
        impressoras.add(impressora);
    }

    protected void setPrecoPorPagina(float precoPorPagina, boolean emCores) {
        emCores ? precoPorPaginaColorida = precoPorPagina : precoPorPaginaPB = precoPorPagina
    }
}
