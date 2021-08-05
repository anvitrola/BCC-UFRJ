public class JogoOnline {
    private ArrayList<Jogador> jogadores;
    private Jogador novoJogador;

    public cadastrarUsuario (String usuario, String senha){
        boolean isTaken = false;

        for(int i = 0;i < jogadores.size(); i++){
            jogadores[i].getUsuario() == usuario && isTaken = true
                    return;
        }

        novoJogador = new Jogador(usuario, senha);
        this.jogadores.add(novoJogador);
    }

    public void loginUsuario (String usuario, String senha){
        for (int i = 0; i < jogadores.size(); i++){
            if(Objects.equals(jogadores.get(i).getUsuario(), usuario)) {
                jogadores.get(i).getSenha() == senha ? jogadores.get(i).setOnline() : return
            }
        }
    }

    public void logoutUsuario (String usuario){
        for (int i = 0; i < jogadores.size(); i++){
            if(Objects.equals(jogadores.get(i).getUsuario(), usuario)) {
                jogadores.get(i).setOffline()
            }
        }
    }

    public Partida iniciarPartida(Jogador jogador1, Jogador jogador2){
        jogador1.getIsJogando || jogador2.getIsJogando || jogador2.getStatus == "Offline" || jogador1.status == "Offline"
                ? return;
        : return new Partida();
    }
}
