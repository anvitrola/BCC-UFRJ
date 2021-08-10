public class GerenteGeral extends Gerente {

    public GerenteGeral(String nome, long cpf, int matricula) {
        super(nome, cpf, matricula);
    }

    @Override
    public void encerrarConta(Conta conta) {
        gerenciarConta(conta);
        super.encerrarConta(conta);
    }
}
