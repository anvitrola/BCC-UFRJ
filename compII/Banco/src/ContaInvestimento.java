public class ContaInvestimento extends Conta{

    String tipoInvestimento;
    float taxaJuros;

    public ContaInvestimento(int numeroDaConta, Correntista correntista, String tipoInvestimento, float taxaJuros) {
        super(numeroDaConta, correntista);
        this.taxaJuros = taxaJuros;
        this.tipoInvestimento = tipoInvestimento;
    }

    private float aplicarJuros (){
        return this.saldo * (1 + this.taxaJuros/100);
    }

    private void resgatarTotal(){

    }
}
