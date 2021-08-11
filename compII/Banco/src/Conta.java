import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;

public class Conta {
    protected final int numero;

    protected Correntista correntista;
    private final long cpfCorrentista;

    protected float saldoEmReais;
    Gerente gerente;

    private ArrayList<String> transacoes;
    private boolean ativa;
    public static final float SALDO_INICIAL_DA_CONTA = 10; // "constante"
    private static int quantidadeDeTransacoesDeTodasAsContas = 0;

    // CONSTRUTOR: método especial que roda quando chamamos o "new" para instanciar
    public Conta(int numeroDaConta, @NotNull Correntista correntista
    ) {
        this.cpfCorrentista = correntista.getCpf();
        this.numero = numeroDaConta;
        this.saldoEmReais = SALDO_INICIAL_DA_CONTA; // saldo inicial doado pelo banco
        this.transacoes = new ArrayList<>();
        this.transacoes.add("Conta criada com saldo de " + this.saldoEmReais);
        this.ativa = true;
        this.correntista = correntista;
        this.correntista.setContaCorrente(this);
    }

    public boolean isAtiva() {
        return this.ativa;
    }

    public float getSaldoEmReais() {
        return this.saldoEmReais;
    }

    public void receberDepositoEmDinheiro(float valor) {
        if (valor <= 0) {
            return; // valor inválido; não faz nada!
            // ToDo lançar uma exceção
        }

        this.saldoEmReais += valor;
        registrarTransacao(
                String.format("Depósito de R$%.2f efetuado com sucesso.",
                        valor)
        );
    }

    public long getCpfDoCorrentista() {
        return this.cpfCorrentista;
    }

    public String getExtrato() {
        String resultado = "";

        for (int i = 0; i < transacoes.size(); i++) {
            resultado += transacoes.get(i) + "\n";
        }

        return resultado;
    }

    public static int getQuantidadeDeTransacoesDeTodasAsContas() {
        return quantidadeDeTransacoesDeTodasAsContas;
    }

    public void sacar(float valor) {
        if (valor > this.saldoEmReais)
            return;

        this.saldoEmReais -= valor;

        registrarTransacao(
                String.format("Saque de R$%.2f efetuado com sucesso.",
                        valor)
        );
    }

    protected void efetuarTransferecia(Conta contaDestino, float valor) {
        if (valor > this.saldoEmReais) {
            return;
        } else if (valor <= 0) {
            return;
        }

        this.saldoEmReais-= valor;
        contaDestino.saldoEmReais += valor;

        registrarTransacao(
                String.format("Transferência para conta %d no valor de R$%.2f",
                contaDestino.numero,
                valor)
        );
    }

    private void registrarTransacao (String registro){
        Date dataAtual = new Date();
        this.transacoes.add(dataAtual + ": " + registro);
        quantidadeDeTransacoesDeTodasAsContas++;
    }

    protected void encerrar() {
        if (this.saldoEmReais < 0) {
            throw new RuntimeException("Não e possível encerrar conta com saldo negativo. Consulte a gerência");
        }
        this.ativa = false;

        System.out.printf("\nConta %d encerrada", this.numero);
    }

    public Gerente getGerente() {
        return this.gerente;
    }

    protected void setGerente(Gerente novaGerente) {
        if (this.gerente != null) {
            // avisa ao gerente antigo que ele não é mais gerente
            this.gerente.deixarDeGerenciarConta(this);
        }
        this.gerente = novaGerente;
    }
}
