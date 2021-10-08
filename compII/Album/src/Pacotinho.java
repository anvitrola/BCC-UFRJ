import java.lang.reflect.Array;
import java.util.ArrayList;

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
