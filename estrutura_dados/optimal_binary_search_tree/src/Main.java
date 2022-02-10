import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 50;
        Random random = new Random(123456);

        OptimalBinarySearchTree optimalBST = new OptimalBinarySearchTree();

        List<KeyAndFrequency> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(new KeyAndFrequency(i, 1 + random.nextInt(10)));
        }

        int minimalWeight = optimalBST.getOptimalBSTWeight(list);

        System.out.println(minimalWeight);

    }
}
