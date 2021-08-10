import org.jetbrains.annotations.NotNull;
import java.util.Date;

public class PessoaFisica {
    private final long cpf;
    private String nome;
    private Date dataNascimento;
    private String endereco;

    public PessoaFisica(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = "Nao informado";
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(@NotNull String nome) {
        if (nome.length() > 30) {
            throw new RuntimeException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
