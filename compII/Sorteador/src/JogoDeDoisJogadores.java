import java.util.ArrayList;

public abstract class JogoDeDoisJogadores {
    public String nomeJogo;
    public String nomeJogador1;
    public String nomeJogador2;
    public int numeroDeRodadas;

    public static final int EMPATE = 0;
    public static final int VITORIA_JOGADOR_1 = 1;
    public static final int VITORIA_JOGADOR_2 = 2;

    public ArrayList<Partida> historicoResultados;

    public JogoDeDoisJogadores(String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas) {
        this.nomeJogo = nomeJogo;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroDeRodadas = numeroDeRodadas;
        this.historicoResultados = new ArrayList<>();
    }

    protected abstract int executarRodadaDoJogo();

    public String getNomeJogo() {
        return this.nomeJogo;
    }

    public String getNomeJogador1() {
        return this.nomeJogador1;
    }

    public String getNomeJogador2() {
        return this.nomeJogador1;
    }

    public int getNumeroDeRodadas() {
        return this.numeroDeRodadas;
    }

    public String jogar() {
        int pontosJogador1 = 0;
        int pontosJogador2 = 0;

        while (numeroDeRodadas > 0) {
            int resultadoDaRodada = executarRodadaDoJogo();
            historicoResultados.add(resultadoDaRodada);
            numeroDeRodadas--;
        }

        for (int i = 0; i < historicoResultados.size(); i++) {
            if (historicoResultados.get(i) == 1)
                pontosJogador1++;
            else if (historicoResultados.get(i) == 2)
                pontosJogador2++;
        }

        if (pontosJogador1 > pontosJogador2)
            return String.format("O(A) jogador(a) %s venceu o jogo por %d a %d.", nomeJogador1, pontosJogador1,
                    pontosJogador2);
        else if (pontosJogador1 < pontosJogador2)
            return String.format("O(A) jogador(a) %s venceu o jogo por %d a %d.", nomeJogador2, pontosJogador2,
                    pontosJogador1);

        return String.format("O jogo terminou em empate após %d rodadas.", numeroDeRodadas);
    }

    public String obterResultadoUltimoJogo() {

        if (this.historicoResultados.isEmpty()) {
            return null;
        }

        Partida ultimaPartidaJogada = this.historicoResultados.get(this.historicoResultados.size() - 1);

        int contRodadasVencidasJogador1 = ultimaPartidaJogada.contRodadasVencidasJogador1;
        int contRodadasVencidasJogador2 = ultimaPartidaJogada.contRodadasVencidasJogador2;

        if (contRodadasVencidasJogador1 == contRodadasVencidasJogador2) {
            return String.format("O jogo terminou em empate após %d rodadas.", this.numeroDeRodadas);
        } else {

            String nomeVencedor;
            int pontosVencedor;
            int pontosPerdedor;

            if (contRodadasVencidasJogador1 > contRodadasVencidasJogador2) {
                nomeVencedor = this.nomeJogador1;
                pontosVencedor = contRodadasVencidasJogador1;
                pontosPerdedor = contRodadasVencidasJogador2;
            } else {
                nomeVencedor = this.nomeJogador2;
                pontosVencedor = contRodadasVencidasJogador2;
                pontosPerdedor = contRodadasVencidasJogador1;
            }

            return String.format("O jogador %s venceu o jogo por %d a %d", nomeVencedor, pontosVencedor,
                    pontosPerdedor);
        }
    }

    public float getPercentualVitoriasJogador1() {
        Partida ultimaPartida = this.historicoResultados.get(this.historicoResultados.size() - 1);
        return (ultimaPartida.contRodadasVencidasJogador1 / numeroDeRodadas) * 100;
    }

    public float getPercentualVitoriasJogador2() {
        Partida ultimaPartida = this.historicoResultados.get(this.historicoResultados.size() - 1);
        return (ultimaPartida.contRodadasVencidasJogador2 / numeroDeRodadas) * 100;
    }

    public float getPercentualEmpates() {
        Partida ultimaPartida = this.historicoResultados.get(this.historicoResultados.size() - 1);
        return (ultimaPartida.contEmpates / numeroDeRodadas) * 100;
    }

    private class Partida {
        final int contRodadasVencidasJogador1;
        final int contRodadasVencidasJogador2;
        final int contEmpates;

        Partida(int contRodadasVencidasJogador1, int contRodadasVencidasJogador2, int contEmpates) {
            this.contRodadasVencidasJogador1 = contRodadasVencidasJogador1;
            this.contRodadasVencidasJogador2 = contRodadasVencidasJogador2;
            this.contEmpates = contEmpates;
        }
    }
}
