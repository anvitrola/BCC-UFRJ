package controle;

import excecao.DevolucaoInvalidaException;
import excecao.LimiteEmprestimosExcedidoException;
import excecao.UsuarioNaoCadastradoException;
import modelo.Livro;
import modelo.Usuario;

import java.util.HashMap;

public class Biblioteca {

    public static final int MIN_COPIAS_PARA_PODER_EMPRESTAR = 2;
    public static final int MAX_LIVROS_DEVIDOS = 3;
    private int TOTAL_USUARIOS_CADASTRADOS = 0;
    private int QUANTIDADE_LIVROS_NA_ESTANTE = 0;

    private HashMap<Long, Usuario> usuarios = new HashMap<>();
    private HashMap<Livro, Integer> acervo = new HashMap<>();

    public void cadastrarUsuario(Usuario usuario) {
        Long cpf = usuario.getCpf();

        if(usuarios.containsKey(cpf)){
            String nomeNovo = usuario.getNome();
            String enderecoNovo = usuario.getEndereco();

            usuarios.get(cpf).setEndereco(enderecoNovo);
            usuarios.get(cpf).setNome(nomeNovo);

            return;
        }

        usuarios.put(cpf, usuario);
        this.TOTAL_USUARIOS_CADASTRADOS++;
    }

    public Usuario getUsuario(long cpf) {
        if(usuarios.containsKey(cpf))
            return usuarios.get(cpf);
        return null;
    }

    public int getTotalDeUsuariosCadastrados() {
        return this.TOTAL_USUARIOS_CADASTRADOS;
    }

    public void incluirLivroNoAcervo(Livro livro, int quantidade) {
        acervo.put(livro, quantidade);
        this.QUANTIDADE_LIVROS_NA_ESTANTE += quantidade;
    }

    public boolean emprestarLivro(Livro livro, Usuario usuario)
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {
        if(!acervo.containsKey(livro))
            return false;

        int qtdCopiasLivroRequisitado = acervo.get(livro);

        if(!usuarios.containsKey(usuario.getCpf()))
            throw new UsuarioNaoCadastradoException();

        if(usuario.getQuantidadeLivrosDevidos() >= MAX_LIVROS_DEVIDOS || qtdCopiasLivroRequisitado == 1)
            throw new LimiteEmprestimosExcedidoException();

        usuario.emprestarLivro(livro);

        this.QUANTIDADE_LIVROS_NA_ESTANTE--;
        acervo.replace(livro, qtdCopiasLivroRequisitado--);

        return true;
    }

    public void receberDevolucaoLivro(Livro livro, Usuario usuario) throws DevolucaoInvalidaException {
        int qtdCopiasLivroRequisitado = acervo.get(livro);
        if(!usuario.possuiObjeto(livro))
            throw new DevolucaoInvalidaException();
        usuario.devolverLivro(livro);
        acervo.replace(livro, qtdCopiasLivroRequisitado++);
    }

    public int getQuantidadeDeLivrosDevidos(Usuario usuario) {
        return usuario.getQuantidadeLivrosDevidos();
    }

    public int getQuantidadeDeLivrosNaEstante() {
        return this.QUANTIDADE_LIVROS_NA_ESTANTE;
    }

    public int getQuantidadeDeLivrosNaEstante(Livro livro) {
        if(!acervo.containsKey(livro))
            return 0;
        return acervo.get(livro).intValue();
    }
}
