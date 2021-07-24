public class Correntista {
    private final long cpf;
    private String nome;

    public Correntista (String nome, long cpf){
        this.cpf = cpf;
        this.nome = setNome(nome);
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    public long getCpf(){
        return this.cpf;
    }

}
