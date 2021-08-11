public class ContaInvestimento extends Conta{
    private String tipoInvestimento;
    private double taxaJuros;

    public ContaInvestimento(int numeroDaConta, Correntista correntista, String tipoInvestimento, double taxaJuros) {
        super(numeroDaConta, correntista);

        if (correntista.getContaCorrente() == null)
            throw new RuntimeException("Correntista sem conta corrente!");

        this.taxaJuros = taxaJuros;
        this.tipoInvestimento = tipoInvestimento;
        this.correntista.setContasInvestimento(this);
    }

    private double aplicarJuros (){
        return this.saldoEmReais * (1 + this.taxaJuros/100);
    }

    private void resgatarTotal(){
        this.efetuarTransferecia(correntista.getContaCorrente(), this.saldoEmReais);
    }

    public ContaInvestimento getContaInvestimento(){
        return this;
    }
}
