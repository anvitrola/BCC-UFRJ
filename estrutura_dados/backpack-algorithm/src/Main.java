import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<WeightAndValue> items = new ArrayList<>();

        items.add(new WeightAndValue(100,5));
        items.add(new WeightAndValue(500,7));
        items.add(new WeightAndValue(450,4));

        System.out.println(Backpack.getBetterBackpack(items, 10));
    }
}
