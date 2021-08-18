public abstract class Impressora {
    private int folhasRestantes;
    private int qtdDocsImpressos;

    public boolean imprimirDocumento(Documento documento) {
        if (documento.getQuantPaginas() > this.folhasRestantes){
            return false;
        }

        for (int i = 1; i <= documento.getQuantPaginas(); i++) {
            executarImpressaoPagina(documento.getPagina(i));
            folhasRestantes--;
        }

        qtdDocsImpressos++;
        return true;
    }

    public void carregarPapel(int numeroDeFolhas) {
        this.folhasRestantes += numeroDeFolhas;
    }

    public int getQuantidadeFolhasRestantes() {
        return this.folhasRestantes;
    }

    public int getQuantidadeDocumentosImpressos() {
        return this.qtdDocsImpressos;
    }

    public abstract void executarRotinaLimpeza();

    public abstract void executarImpressaoPagina(String pagina);
}
