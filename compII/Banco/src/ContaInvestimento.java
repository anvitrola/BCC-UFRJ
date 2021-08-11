public class ContaInvestimento extends Conta{
    private String tipoInvestimento;
    private float taxaJuros;

    public ContaInvestimento(int numeroDaConta, Correntista correntista, String tipoInvestimento, float taxaJuros) {
        super(numeroDaConta, correntista);

        if (correntista.getContaCorrente() == null)
            throw new RuntimeException("Correntista sem conta corrente!");

        this.taxaJuros = taxaJuros;
        this.tipoInvestimento = tipoInvestimento;
    }

    private float aplicarJuros (){
        return this.saldoEmReais * (1 + this.taxaJuros/100);
    }

    private void resgatarTotal(){
        this.efetuarTransferecia(this.correntista.getContaCorrente(), this.saldoEmReais);
    }
}
