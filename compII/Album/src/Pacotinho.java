import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A classe Pacotinho é uma extensão da classe ArrayList. Ela aceita apenas, no entanto,
 * tipos que sejam colecionáveis. Além disso, ela reecbe em seu construtor um tamanho,
 * tamanho esse que será verificado a cada add(). Se a quantidade de itens inseridos já for
 * igual ao tamanho informado no construtor, então o método add() deve lançar uma exceção
 * IllegalStateException (runtime exception).
 *
 * @param <T> o tipo colecionável
 */
public class Pacotinho<T extends Colecionavel> extends ArrayList<T> {

    public int tamanho;
    ArrayList<T> figurinhas;

    public Pacotinho(int tamanho) {
        super();

        this.tamanho = tamanho;
        this.figurinhas = new ArrayList<>();
    }

    public ArrayList<T> getFigurinhas(){
        return this.figurinhas;
    }

    @Override
    public boolean add(T elemento) {
        if(tamanho == figurinhas.size())
            throw new IllegalStateException();

        this.figurinhas.add(elemento);
        return true;
    }
}
