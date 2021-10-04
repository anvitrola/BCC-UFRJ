package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario {

    private String nome;
    private long cpf;
    private String endereco;

    private Set<Livro> objetosADevolver = new HashSet<>();

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
        return this.objetosADevolver.size();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void devolverLivro( Livro livro) {
        objetosADevolver.remove(livro);
    }

    public void emprestarLivro (Livro livro) {
        objetosADevolver.add(livro);
    }

    public boolean possuiObjeto (Object obj){
        if(objetosADevolver.contains(obj))
            return true;
        return false;
    }
}
