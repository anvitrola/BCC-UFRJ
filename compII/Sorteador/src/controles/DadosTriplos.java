package controles;

import interfaces.Sorteavel;

public class DadosTriplos implements Sorteavel {
    @Override
    public int sortear (){
        Dado d2 = new Dado();

        int sorteado1 = d2.sortear();
        int sorteado2 = d2.sortear();
        int sorteado3 = d2.sortear();

        return sorteado1 + sorteado2 + sorteado3;
    }
}
