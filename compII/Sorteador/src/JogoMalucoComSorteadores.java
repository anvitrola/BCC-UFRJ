import interfaces.Sorteavel;

public class JogoMalucoComSorteadores extends JogoDeDoisJogadores {
    Sorteavel sorteador1;
    Sorteavel sorteador2;

    public JogoMalucoComSorteadores (Sorteavel sorteador1, Sorteavel sorteador2, String jogador1, String jogador2, int numeroJogadas){
        super("Jogo Malucão com Sorteadores", jogador1, jogador2, numeroJogadas);
        this.sorteador1 = sorteador1;
        this.sorteador2 = sorteador2;
    }

    @Override
    protected int executarRodadaDoJogo() {
        int resultado1 = sorteador1.sortear();
        int resultado2 = sorteador2.sortear();

        if(resultado1 > resultado2)
            return 1;
        else if(resultado1 < resultado2)
            return 2;
        else
            return 0;
    }
}
