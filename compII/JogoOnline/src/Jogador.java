public class Jogador {
    private final String usuario;
    private String senha;
    private boolean isOnline;
    private boolean isJogando;
    private static int pontuacao;
    private ArrayList<Partida> historicoDePartidas;

    public Jogador (String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha; // ToDo: Encrypt
        this.pontuacao = 1000;
        this.historicoDePartidas = new ArrayList<>();
        this.isOnline = true;
    }

    public void setSenha (String novaSenha){
        this.senha = novaSenha;
    }

    public String getUsuario () {
        return this.usuario;
    }

    public int getPontuacao (){
        return this.pontuacao;
    }

    public String getHistorico() {
        String historico = "";

        for (int i = 0; i < historicoDePartidas.size(); i++) {
            historico += historicoDePartidas.get(i) + "\n";
        }

        return historico;
    }

    public void registrarPartida (String partida, boolean isVencedor){
        Date data = new Date();
        this.historicoDePartidas.add(data + ": " + partida);

        isVencedor ? pontuacao++ : pontuacao--;
    }

    public void setStatus (){
        isOnline = !isOnline;
    }

    public boolean getStatus (){
        return this.isOnline;
    }

    public boolean setIsJogando (){
        isJogando = !isJogando;
    }

    public void getIsJogando(){
        return isJogando;
    }
}
