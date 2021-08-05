public class Jogador {
    private final String usuario;
    private String senha;
    private boolean status; //true = online false = offline
    private boolean isJogando;
    private static int pontuacao;
    private int PONTUACAO_INICIAL = 1000;
    private ArrayList<Partida> historicoDePartidas;

    public Jogador (String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha; // ToDo: Encrypt
        this.pontuacao = PONTUACAO_INICIAL;
        this.historicoDePartidas = new ArrayList<>();
        this.status = true;
        this.isJogando = false;
    }

    public void setSenha (String novaSenha){
        this.senha = novaSenha;
    }

    private String getSenha (){
        return this.senha
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

    public void setOnline (){
        status = true;
    }

    public void setOffline(){
        status = false;
    }

    public String getStatus (){
        this.status
                ? return "Online"
        : "Offline"
    }

    public boolean setIsJogando (){
        isJogando = true;
    }

    public boolean setIsAvaidable(){
        isJogando = false;
    }

    public void getIsJogando(){
        return isJogando;
    }

    public void registrarPartida (Partida partida){
        Date data = new Date();
        this.historicoDePartidas.add(data + ": " + partida);
    }

    private void registrarVitoria(Partida partida){
        registrarPartida(partida);
        pontuacao++;
    }

    private void registrarDerrota(Partida partida){
        registrarPartida(partida);
        pontuacao--;
    }

    private void registrarEmpate(Partida partida){
        registrarPartida(partida);
    }
}
