import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogoOnlineTest {

    private JogoOnline jogo;

    @Before
    public void setUp() {
        jogo = new JogoOnline();
    }


    @Test
    public void testarCadastroELogin() {
        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        assertNotNull(jogadorJoao);
        assertEquals("joao", jogadorJoao.getUsername());

        try{
            jogo.fazerLogin("joao", "1234");
        } catch (Exception e){
            System.out.println("Uma UsuarioInexistenteException ou SenhaInvalidaException deve ser lançada se o username for desconhecido " +
                    "ou a senha estiver incorreta");
        }

        assertTrue("Após o login (e antes do logout), o jogador " +
                "deve ser considerado online",
                jogadorJoao.isOnline());

    }

    @Test(expected = UsuarioInexistenteException.class)
    public void testarLoginComUsuarioDesconhecido() {
        try{
            jogo.fazerLogin("joao", "1234");
            fail("Deverá lançar uma UsuarioInexistenteException");
        } catch (UsuarioInexistenteException | SenhaInvalidaException e){
            System.out.println(e);
        }
    }

    @Test
    public void testarCadastroELoginComSenhaIncorreta() {
        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        assertNotNull(jogadorJoao);
        assertEquals("joao", jogadorJoao.getUsername());

        try {
            jogo.fazerLogin("joao", "3246523");
            fail("O fazerLogin deveria lançar uma SenhaInvalidaException!!!");

        } catch (UsuarioInexistenteException e) {
            System.out.println("Usuário inexistente.");
        } catch (SenhaInvalidaException e) {
            System.out.println("Senha inválida.");
        }

        assertFalse(jogadorJoao.isOnline());
    }

    @Test
    public void testarIniciarPartida() {
        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");

        try {
            jogo.fazerLogin("joao", "1234");
            jogo.fazerLogin("maria", "3456");
        } catch (SenhaInvalidaException | UsuarioInexistenteException e){
            System.out.println("Usuário inexistente ou senha incorreta");
        }

        // sanity check
        assertFalse(jogadorJoao.isJogando());
        assertFalse(jogadoraMaria.isJogando());

        Partida partida = jogo.iniciarPartida(jogadorJoao, jogadoraMaria);

        assertEquals(jogadorJoao, partida.getJogador1());
        assertEquals(jogadoraMaria, partida.getJogador2());
        assertEquals(Partida.PARTIDA_EM_ANDAMENTO,
                partida.getResultado());
        assertTrue(jogadorJoao.isJogando());
        assertTrue(jogadoraMaria.isJogando());
    }

    @Test
    public void testarLogout() {
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");

        try{
            jogo.fazerLogin("maria", "3456");
        } catch (SenhaInvalidaException | UsuarioInexistenteException e){
            System.out.println("Usuário inexistente ou senha incorreta");
        }

        assertTrue(jogadoraMaria.isOnline());

        try{
            jogo.fazerLogout(jogadoraMaria);
        } catch (RuntimeException e) {
            System.out.println("Impossível deslogar jogador offline");
        }
        
        assertFalse(jogadoraMaria.isOnline());
    }

    @Test(expected = RuntimeException.class)
    public void testarLogoutDeJogadorNaoOnline() {
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");

        jogo.fazerLogout(jogadoraMaria);
        // impossível fazer o logou t de jogador que nõ está online,
        // então esperamos tomar uma RuntimeException
    }
}
