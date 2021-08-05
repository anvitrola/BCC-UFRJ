import java.util.ArrayList;
import java.util.Objects;

public class JogoOnline {
    private ArrayList<Jogador> jogadores;

    public cadastrarUsuario (String usuario, String senha){
        boolean isTaken = false;

        for(int i = 0;i < jogadores.size(); i++){
            jogadores[i].getUsuario() == usuario && isTaken = true
                    return;
        }

        Jogador novoJogador = new Jogador(usuario, senha);
        this.jogadores.add(novoJogador);
    }

    public void loginUsuario (String usuario, String senha){
        for (int i = 0; i < jogadores.size(); i++){
            if(Objects.equals(jogadores.get(i).getUsuario(), usuario)) {
                Object.equals(jogadores.get(i).getSenha(), senha) ? jogadores.get(i).setOnline() : return
            }
        }
    }

    public void logoutUsuario (Jogador jogador){
        jogador.setOffine()
    }

    public Partida iniciarPartida(Jogador jogador1, Jogador jogador2){
        String off = new String("Offline");
        jogador1.getIsJogando() || jogador2.getIsJogando() || jogador2.getStatus().equals(off) || jogador1.status().equals(off)
                ? return;
        : return new Partida();
    }

    public Jogador escolherAdversario (Jogador jogador){
        String on = new String("Online");
        for(int i = 0; i < jogadores.size(); i++){
            if (jogadores.get(i) != jogador && jogadores.get(i).getStatus().equals(on) && !jogadores.get(i).getIsJogando()){
                return jogadores.get(i);
            }
        }
    }

    private void encerrarPartida(Partida partida, int resultado){
        partida.jogador1.setIsAvaidable();
        partida.jogador2.setIsAvaidable();

        switch (resultado) {
            case 1:
                partida.setResultado(1)
            case 2:
                partida.setResultado(2)
            default:
                partida.setResultado(0)
        }
    }

}
