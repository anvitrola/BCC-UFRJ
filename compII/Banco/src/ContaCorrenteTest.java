import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContaCorrenteTest {

        // para cobrir pequenos erros de precisão do tipo float
        private final float FLOAT_DELTA = 0.00001f;
        private final long cpfMaria = 12345678;
        private final long cpfJoao = 54654757;


        private ContaCorrente contaDoJoao;
        private Correntista joao;
        private ContaCorrente contaDaMaria;
        private Correntista maria;
        private float saldoInicial;

        @Before
        public void setUp() {
                joao = new Correntista("Joao", cpfJoao);
                contaDoJoao = new ContaCorrente(1, joao);

                maria = new Correntista("Maria", cpfMaria);
                contaDaMaria = new ContaCorrente(2, maria);

                saldoInicial = contaDoJoao.getSaldoEmReais();
        }

        @Test
        public void testarSaldoInicialDaConta() {
                assertEquals("Toda conta, ao ser criada, deve começar com saldo de R$10,00.", 
                10.0, 
                saldoInicial,
                FLOAT_DELTA);
        }

        @Test
        public void testarRecebimentoDepositoParaValoresValidos() {
                contaDoJoao.receberDepositoEmDinheiro(50);

                assertEquals("O saldo da conta deve ser atualizado após receber um depósito.", 
                saldoInicial + 50,
                contaDoJoao.getSaldoEmReais(), 
                FLOAT_DELTA);
        }

        @Test
        public void testarRecebimentoDepositoParaValoresNegativos() {
                contaDoJoao.receberDepositoEmDinheiro(-200);

                assertEquals("Depósitos de valores negativos devem ser solenemente ignorados.", 
                saldoInicial,
                contaDoJoao.getSaldoEmReais(), 
                FLOAT_DELTA);
        }

        @Test
        public void testarRecebimentoDepositoParaValorZero() {
                String extratoAntes = contaDoJoao.getExtrato();

                contaDoJoao.receberDepositoEmDinheiro(0);
                assertEquals("Depósitos de valor zero devem ser ignorados.", 
                saldoInicial, 
                contaDoJoao.getSaldoEmReais(),
                FLOAT_DELTA);

                String extratoDepois = contaDoJoao.getExtrato();

                assertEquals("Depósitos ignorados não devem sequer constar do extrato.", 
                extratoAntes, 
                extratoDepois);
        }

        @Test
        public void testarSaqueComFundos() {
                contaDoJoao.sacar(2);
                
                assertEquals("O valor sacado deve ser descontado do saldo da conta.", 
                saldoInicial - 2,
                contaDoJoao.getSaldoEmReais(),
                        FLOAT_DELTA);
        }

        @Test
        public void testarSaqueSemFundos() {
                contaDoJoao.sacar(100000);

                assertEquals("Saques de valores maiores que o saldo não devem ser permitidos.", 
                saldoInicial,
                contaDoJoao.getSaldoEmReais());
        }

        @Test
        public void testarTransferencia() {
                contaDoJoao.efetuarTransferecia(contaDaMaria, 3);

                assertEquals("O saldo da conta destino deve ser incrementado dem 3, valor da transferência.", 
                saldoInicial + 3, 
                contaDaMaria.getSaldoEmReais(), 
                FLOAT_DELTA);

                assertEquals("O saldo da conta destino deve ser decrementado dem 3, valor da transferência.", 
                saldoInicial - 3, 
                contaDoJoao.getSaldoEmReais(), 
                FLOAT_DELTA);
        }

        @Test
        public void testarTransferenciaSemFundos() {
                contaDoJoao.efetuarTransferecia(contaDaMaria, 100000);

                assertEquals("O saldo da conta destino deve permanecer o mesmo, visto que a transferência é sem fundos.", 
                saldoInicial, 
                contaDaMaria.getSaldoEmReais(), 
                FLOAT_DELTA);

                assertEquals("O saldo da conta origem deve permanecer o mesmo, visto que a transferência é sem fundos.", 
                saldoInicial, 
                contaDoJoao.getSaldoEmReais(), 
                FLOAT_DELTA);
        }

        @Test
        public void testarGetCpfCorrentista() {
                long cpfDaContaDaMaria = contaDaMaria.getCpfDoCorrentista();
                long cpfDaContaDoJoao = contaDoJoao.getCpfDoCorrentista();

                assertEquals("O CPF cadastrado na conta deve ser o mesmo que o do correntista.", 
                cpfMaria, 
                cpfDaContaDaMaria);

                assertEquals("O CPF cadastrado na conta deve ser o mesmo que o do correntista.", 
                cpfJoao, 
                cpfDaContaDoJoao);
        }

        @Test 
        public void testarQuantidadeDeTransacoesDeTodasAsContas(){
                int quantidadeDeTransacoesAnteriores = contaDoJoao.getQuantidadeDeTransacoesDeTodasAsContas();

                contaDoJoao.receberDepositoEmDinheiro(30.0F);
                contaDoJoao.sacar(10F);
                contaDaMaria.receberDepositoEmDinheiro(10.0F);

                assertEquals("O número de transações de todas as contas deverá retornar o número de movimentações feitas.",
                ContaCorrente.getQuantidadeDeTransacoesDeTodasAsContas(),
                        quantidadeDeTransacoesAnteriores + 3);
        }

        @Test
        public void testarCpfValido(){
                //to-do: testar validade do CPF inserido. tem que ter 11 dígitos
        }

}