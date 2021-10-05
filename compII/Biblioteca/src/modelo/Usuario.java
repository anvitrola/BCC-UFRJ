package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario {

    private String nome;
    private long cpf;
    private String endereco;

    private Set<Livro> objetosADevolver = new HashSet<>();
    protected int QTD_LIVROS_DEVIDOS = 0;

    public Usuario(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public int getQuantidadeLivrosDevidos(){
        return QTD_LIVROS_DEVIDOS;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void devolverLivro( Livro livro) {
        objetosADevolver.remove(livro);
        QTD_LIVROS_DEVIDOS--;
    }

    public void emprestarLivro (Livro livro) {
        objetosADevolver.add(livro);
        QTD_LIVROS_DEVIDOS++;
    }

    public boolean possuiObjeto (Object obj){
        if(objetosADevolver.contains(obj))
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return cpf == usuario.cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
