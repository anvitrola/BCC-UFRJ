import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JogoOnlineTest {

    private JogoOnline jogo;
    private Jogador jogador1;
    private Jogador jogador2;
    private Partida partida;

    @Before
    public void setUp(){
        jogo = new JogoOmline();
        jogador1 = jogo.cadastrarUsuario('anvitrola', 'sEnHaSupeRForTe');
        jogador2 = jogo.cadastrarUsuario('b.a.fera', 'suPeRsenhaa');
        partida = jogo.
    }

}
