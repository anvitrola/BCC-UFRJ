public class Partida {
    Jogador jogador1;
    Jogador jogador2;
    Jogador ganhador;

    public Partida (Jogador jogador1, Jogador jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;

        jogador1.setIsJogando
    }

    public int getResultado (Jogador ganhador){
        switch (ganhador) {
            case ganhador.equals(this.jogador1):
                return 1;
            case ganhador.equals(this.jogador2):
                return 2;
            default:
                return 0;
        }
    }


}
