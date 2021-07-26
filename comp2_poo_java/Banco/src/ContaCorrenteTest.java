import org.junit.Before;
import org.junit.Test;

import jdk.jfr.Timestamp;

import static org.junit.Assert.assertEquals;

public class ContaCorrenteTest {

        // para cobrir pequenos erros de precisão do tipo float
        private float FLOAT_DELTA = 0.00001f;
        private int cpfTeste = 12345678;

        private ContaCorrente contaDoJoao;
        private Correntista joao;
        private ContaCorrente contaDaMaria;
        private Correntista maria;
        private float saldoInicial;

        @Before
        public void setUp() {
                joao = new Correntista("Joao", 5465475);
                contaDoJoao = new ContaCorrente(1, joao);

                maria = new Correntista("Maria", cpfTeste);
                contaDaMaria = new ContaCorrente(2, maria);

                saldoInicial = contaDoJoao.getSaldoEmReais();
        }

        @Test
        public void testarSaldoInicialDaConta() {
                assertEquals("Toda conta, ao ser criada, deve começar com saldo de R$10,00.", 10.0, saldoInicial,
                                FLOAT_DELTA);
        }

        @Test
        public void testarRecebimentoDepositoParaValoresValidos() {
                contaDoJoao.receberDepositoEmDinheiro(50);
                assertEquals("O saldo da conta deve ser atualizado após receber um depósito", saldoInicial + 50,
                                contaDoJoao.getSaldoEmReais(), FLOAT_DELTA);
        }

        @Test
        public void testarRecebimentoDepositoParaValoresNegativos() {
                contaDoJoao.receberDepositoEmDinheiro(-200);
                assertEquals("Depósitos de valores negativos devem ser solenemente ignorados", saldoInicial,
                                contaDoJoao.getSaldoEmReais(), FLOAT_DELTA);
        }

        @Test
        public void testarRecebimentoDepositoParaValorZero() {
                String extratoAntes = contaDoJoao.getExtrato();

                contaDoJoao.receberDepositoEmDinheiro(0);
                assertEquals("Depósitos de valor zero devem ser ignorados", saldoInicial, contaDoJoao.getSaldoEmReais(),
                                FLOAT_DELTA);

                String extratoDepois = contaDoJoao.getExtrato();

                assertEquals("Depósitos ignorados não devem sequer constar do extrato", extratoAntes, extratoDepois);

        }

        @Test
        public void testarSaqueComFundos() {
                contaDoJoao.sacar(2);
                assertEquals("O valor sacado deve ser descontado do saldo da conta", saldoInicial - 2,
                                contaDoJoao.getSaldoEmReais());
        }

        @Test
        public void testarSaqueSemFundos() {
                contaDoJoao.sacar(100000);
                assertEquals("Saques de valores maiores que o saldo não devem ser permitidos", saldoInicial,
                                contaDoJoao.getSaldoEmReais());
        }

        @Test
        public void testarTransferencia() {
                contaDoJoao.efetuarTransferecia(contaDaMaria, 3);

                assertEquals("", saldoInicial + 3, contaDaMaria.getSaldoEmReais(), FLOAT_DELTA);

                assertEquals("", saldoInicial - 3, contaDoJoao.getSaldoEmReais(), FLOAT_DELTA);
        }

        @Test
        public void testarTransferenciaSemFundos() {
                contaDoJoao.efetuarTransferecia(contaDaMaria, 100000);

                assertEquals("O valor de transferência deve ser igual ou inferior ao saldo em conta", saldoInicial, contaDaMaria.getSaldoEmReais(), FLOAT_DELTA);

                assertEquals("O saldo após a transferência deve ser diferente do saldo inicial", saldoInicial, contaDoJoao.getSaldoEmReais(), FLOAT_DELTA);
        }

        @Test
        public void testarGetCpfCorrentista() {
                assertEquals("O CPF cadastrado na conta deve ser o mesmo que o do correntista", cpfTeste, contaDaMaria.getCpfDoCorrentista(), cpfTeste);
        }

        @Test 
        public void testarQuantidadeDeTransacoesDeTodasAsContas(){
                contaDoJoao.sacar(10);
                contaDoJoao.receberDepositoEmDinheiro(30);
                contaDaMaria.receberDepositoEmDinheiro(10);
                assertEquals("O número de transações de todas as contas deve ser gerado corretamente", ContaCorrente.getQuantidadeDeTransacoesDeTodasAsContas(), 3);
        }

}