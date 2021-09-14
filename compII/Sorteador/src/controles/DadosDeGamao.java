package controles;

import interfaces.Sorteavel;

public class DadosDeGamao implements Sorteavel {
    @Override
    public int sortear(){
        Dado d2 = new Dado();

        int sorteado1 = d2.sortear();
        int sorteado2 = d2.sortear();

        if(sorteado1 == sorteado2)
                return 2 * (sorteado1 + sorteado2);

        return sorteado1 + sorteado2;
    }
}
