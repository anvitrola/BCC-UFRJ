public class JogoOnline {
    private ArrayList<Jogador> jogadores;
    private Jogador novoJogador;

    public cadastrarUsuario (String usuario, String senha){
        novoJogador = new Jogador(usuario, senha);
        this.jogadores.add(novoJogador);
    }

    public void login (String usuario, String senha){

    }

    public Partida iniciarPartida(Jogador jogador1, Jogador jogador2){

    }
}
