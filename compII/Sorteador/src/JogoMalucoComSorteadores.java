import interfaces.Sorteavel;

public class JogoMalucoComSorteadores<S1 extends Sorteavel, S2 extends Sorteavel> extends JogoDeDoisJogadores {
    private S1 sorteador1;
    private S2 sorteador2;

    public JogoMalucoComSorteadores (S1 sorteador1, S2 sorteador2, String jogador1, String jogador2, int numeroJogadas){
        super("Jogo Malucão com Sorteadores", jogador1, jogador2, numeroJogadas);
        this.sorteador1 = sorteador1;
        this.sorteador2 = sorteador2;
    }

    @Override
    protected Resultado executarRodadaDoJogo() {
        int resultado1 = sorteador1.sortear();
        int resultado2 = sorteador2.sortear();

        if(resultado1 > resultado2)
            return Resultado.VITORIA_JOGADOR_1;
        else if(resultado1 < resultado2)
            return Resultado.VITORIA_JOGADOR_2;
        else
            return Resultado.EMPATE;
    }
}
