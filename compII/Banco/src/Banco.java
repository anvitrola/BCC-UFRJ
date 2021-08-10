public class Banco {
    public static void main(String[] args) {

        Correntista Ana = new Correntista("Ana", 231232);

        //PessoaFisica Maria = new PessoaFisica("Maria", 432212);

        Conta contaDaAna = new Conta(111, Ana);

        Gerente meuGerente = new Gerente("João", 12345678, 1111);
        meuGerente.setEndereco("Novo endereço, numero tal");

        GerenteGeral gerentona = new GerenteGeral("Mariza Silva", 12333, 1);
        gerentona.encerrarConta(contaDaAna);
    }
}
