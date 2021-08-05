public class Partida {
    public Jogador jogador1;
    public Jogador jogador2;
    public int resultado;

    public Partida (Jogador jogador1, Jogador jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;

        jogador1.setIsJogando();
        jogador2.setIsJogando();
    }

    private void setResultado(int resultado){
        this.resultado = resultado

        switch (resultado) {
            case 1:
                this.jogador1.registrarVitoria(this)
                this.jogador2.registrarDerrota(this)
            case 2:
                this.jogador2.registrarVitoria(this)
                this.jogador1.registrarDerrota(this)
            default:
                this.jogador1.registrarEmpate(this);
                this.jogador2.registrarEmpate(this);
        }
    }

}
