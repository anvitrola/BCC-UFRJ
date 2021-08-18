public class ImpressoraJatoDeTinta extends Impressora {
    private int nivelTintaPreta;
    private int nivelTintaCiano;
    private int nivelTintaMagenta;
    private int nivelTintaAmarela;

    @Override
    public void executarRotinaLimpeza() {
        System.out.println("Limpando bicos de impressão e verificando tintas...");
    }

    @Override
    public void executarImpressaoPagina(String pagina) {
        System.out.println("Imprimindo utilizando jatos de tinta...");
    }

    public int getNivelTintaPreta() {
        return this.nivelTintaPreta;
    }

    public int getNivelTintaAmarela() {
        return this.nivelTintaAmarela;
    }

    public int getNivelTintaMagenta() {
        return this.nivelTintaMagenta;
    }

    public int getNivelTintaCiano() {
        return this.nivelTintaCiano;
    }
}
