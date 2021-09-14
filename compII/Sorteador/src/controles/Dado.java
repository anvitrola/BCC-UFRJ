package controles;

import interfaces.Sorteavel;
import java.util.Random;

public class Dado implements Sorteavel{
    public int n_lados = 6;

    @Override
    public int sortear(){
        Random random = new Random();
        int sorteado = random.nextInt(n_lados) + 1;
        return sorteado;
    }
}
