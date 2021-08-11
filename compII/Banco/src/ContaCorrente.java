public class ContaCorrente extends Conta{
    public ContaCorrente(int numeroDaConta, Correntista correntista) {
        super(numeroDaConta, correntista);
        correntista.setContaCorrente(this);
    }
}
