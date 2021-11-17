import java.util.ArrayList;

import org.graalvm.compiler.nodes.NodeView.Default;

public abstract class JogoDeDoisJogadores {
    public String nomeJogo;
    public String nomeJogador1;
    public String nomeJogador2;
    public int numeroDeRodadas;

    enum Resultado {
        EMPATE, VITORIA_JOGADOR_1, VITORIA_JOGADOR_2
    }

    public ArrayList<Partida> historicoResultados;

    private int contPartidasVencidasPeloJogador1;
    private int contPartidasVencidasPeloJogador2;
    private int contPartidasEmpatadas;

    public JogoDeDoisJogadores(String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas) {
        this.nomeJogo = nomeJogo;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroDeRodadas = numeroDeRodadas;

        this.historicoResultados = new ArrayList<>();

        this.contPartidasVencidasPeloJogador1 = 0;
        this.contPartidasVencidasPeloJogador2 = 0;
        this.contPartidasEmpatadas = 0;

    }

    protected abstract Resultado executarRodadaDoJogo();

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

    public Resultado jogar() {
        int pontosJogador1 = 0;
        int pontosJogador2 = 0;

        while (numeroDeRodadas > 0) {
            Resultado resultadoDaRodada = executarRodadaDoJogo();

            switch (resultadoDaRodada) {
                case VITORIA_JOGADOR_1:
                    pontosJogador1++;
                    break;
                case VITORIA_JOGADOR_2:
                    pontosJogador2++;
                    break;
            }
            numeroDeRodadas--;
        }

        Partida partidaTerminada = new Partida(pontosJogador1, pontosJogador2,
                this.numeroDeRodadas - pontosJogador1 - pontosJogador2);
        
        this.historicoResultados.add(partidaTerminada);
        Resultado resultadoFinalDaPartida = partidaTerminada.getResultado();

        switch (resultadoFinalDaPartida) {
            case VITORIA_JOGADOR_1:
                this.contPartidasVencidasPeloJogador1++;
                break;
            case VITORIA_JOGADOR_2:
                this.contPartidasVencidasPeloJogador2++;
                break;
            case EMPATE: default:
                this.contPartidasEmpatadas++;
        }

        return resultadoFinalDaPartida;
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

    public double getPercentualVitoriasJogador1() {
        return (this.contPartidasVencidasPeloJogador1 / this.numeroDeRodadas) * 100.0;
    }

    public double getPercentualVitoriasJogador2() {
        return (this.contPartidasVencidasPeloJogador2 / this.numeroDeRodadas) * 100.0;
    }

    public double getPercentualEmpates() {
        return (this.contPartidasEmpatadas / this.numeroDeRodadas) * 100.0;
    }

    private class Partida {
        final int contRodadasVencidasJogador1;
        final int contRodadasVencidasJogador2;

        Partida(int contRodadasVencidasJogador1, int contRodadasVencidasJogador2, int contEmpates) {
            this.contRodadasVencidasJogador1 = contRodadasVencidasJogador1;
            this.contRodadasVencidasJogador2 = contRodadasVencidasJogador2;
        }

        Resultado getResultado() {
            if (contRodadasVencidasJogador1 > contRodadasVencidasJogador2) {
                return Resultado.VITORIA_JOGADOR_1;
            } else if (contRodadasVencidasJogador1 < contRodadasVencidasJogador2) {
                return Resultado.VITORIA_JOGADOR_2;
            }
            return Resultado.EMPATE;
        }

    }
}
