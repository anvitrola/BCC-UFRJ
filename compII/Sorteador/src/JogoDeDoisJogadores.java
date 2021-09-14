import java.util.ArrayList;

public abstract class JogoDeDoisJogadores {
    public String nomeJogo;
    public String nomeJogador1;
    public String nomeJogador2;
    public int numeroDeRodadas;
    public ArrayList<Integer> historicoResultados;

    public JogoDeDoisJogadores(String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas){
        this.nomeJogo = nomeJogo;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroDeRodadas = numeroDeRodadas;
        this.historicoResultados = new ArrayList<>();
    }

    protected abstract int executarRodadaDoJogo();

    public String getNomeJogo(){return this.nomeJogo;}

    public String getNomeJogador1(){return this.nomeJogador1;}

    public String getNomeJogador2(){return this.nomeJogador1;}

    public int getNumeroDeRodadas(){return this.numeroDeRodadas;}

    public String jogar(){
        int pontosJogador1 = 0;
        int pontosJogador2 = 0;

        while(numeroDeRodadas > 0){
            int resultadoDaRodada = executarRodadaDoJogo();
            historicoResultados.add(resultadoDaRodada);
            numeroDeRodadas--;
        }

        for(int i = 0; i < historicoResultados.size(); i++){
            if(historicoResultados.get(i) == 1)
                pontosJogador1++;
            else if (historicoResultados.get(i) == 2)
                pontosJogador2++;
        }

        if(pontosJogador1 > pontosJogador2)
            return String.format("O(A) jogador(a) %s venceu o jogo por %d a %d.", nomeJogador1, pontosJogador1, pontosJogador2);
        else if(pontosJogador1 < pontosJogador2)
            return String.format("O(A) jogador(a) %s venceu o jogo por %d a %d.", nomeJogador2, pontosJogador2, pontosJogador1);

        return String.format("O jogo terminou em empate após %d rodadas.", numeroDeRodadas);
    }

}
