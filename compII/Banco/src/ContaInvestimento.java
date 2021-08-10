public class ContaInvestimento extends Conta{
    String tipoInvestimento;
    float taxaJuros;
    Correntista correntista;

    public ContaInvestimento(int numeroDaConta, Correntista correntista, String tipoInvestimento, float taxaJuros) {
        super(numeroDaConta, correntista);

        if (correntista.getContaCorrente() == null)
            throw new RuntimeException("Correntista sem conta corrente!");

        this.taxaJuros = taxaJuros;
        this.tipoInvestimento = tipoInvestimento;
        this.correntista = correntista;
    }

    private float aplicarJuros (){
        return this.saldoEmReais * (1 + this.taxaJuros/100);
    }

    private void resgatarTotal(){
        this.efetuarTransferecia(correntista.getContaCorrente(), this.saldoEmReais);
    }
}
