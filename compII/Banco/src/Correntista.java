import java.util.ArrayList;

public class Correntista extends PessoaFisica {
    private ArrayList<ContaInvestimento> contasInvestimento;
    private Conta contaCorrente;

    public Correntista (String nome, long cpf){
        super(nome, cpf);
        this.contaCorrente = null;
        this.contasInvestimento = new ArrayList<>();
    }

    public Conta getContaCorrente() {
        return this.contaCorrente;
    }

    public void setContaCorrente(Conta contaCorrente){
        this.contaCorrente = contaCorrente;
    }

    public ArrayList<ContaInvestimento> getContasInvestimento() {
        return contasInvestimento;
    }

    protected void setContasInvestimento(ContaInvestimento contaInvestimento) {
        this.contasInvestimento.add(contaInvestimento);
    }
}
