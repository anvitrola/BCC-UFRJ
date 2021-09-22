import controles.DadosDeGamao;
import controles.DadosTriplos;

public class Main {
    public static void main(String[] args) {
        for (int numeroDeRodadas = 1; numeroDeRodadas <= 100000; numeroDeRodadas *= 2) {
            JogoMalucoComSorteadores joguinho = new JogoMalucoComSorteadores(new DadosDeGamao(), new DadosTriplos(),
                    "Gusmão", "Ana", 100000);

            joguinho.jogar();

            System.out.println(joguinho.obterResultadoUltimoJogo());

            System.out.printf(
                "Vitórias do Jogador 1: %.2f%c\nVitórias do Jogador 2: %.2f%c\nEmpates: %.2f%c\n",
                    joguinho.getPercentualVitoriasJogador1(),
                    joguinho.getPercentualVitoriasJogador2(),
                    joguinho.getPercentualEmpates()
            );
        }
    }
}

/*
 * O melhor sorteador é: o dado triplo! Desde o início achei que seria isso
 * mesmo, agora tenho PROVAS.
 */