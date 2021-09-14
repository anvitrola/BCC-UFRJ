import controles.DadosDeGamao;
import controles.DadosTriplos;

public class Main {
    public static void main(String[] args) {
        JogoMalucoComSorteadores joguinho = new JogoMalucoComSorteadores(new DadosDeGamao(), new DadosTriplos(), "Gusmão", "Ana", 100000);
        String resultado = joguinho.jogar();
        System.out.println(resultado);
    }
}

/*
* O melhor sorteador é: o dado triplo! Desde o início achei que seria isso mesmo, agora tenho PROVAS.
* */