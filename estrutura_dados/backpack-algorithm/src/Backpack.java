import java.util.List;

public class Backpack {
    public static int getBetterBackpack (List<WeightAndValue> items, int maximumBackpackWeight) {
        return getBackpackOptimalWeight(items, maximumBackpackWeight, 0);
    }

    private static int getBackpackOptimalWeight (List<WeightAndValue> items, int maximumBackpackWeight, int firstItemIndex) {

        if(firstItemIndex >= items.size()) return 0;

        final int firstItemWeight = items.get(firstItemIndex).getWeight();

        int valueIfTheFirstItemIsPacked =
                firstItemWeight <= maximumBackpackWeight
                        ? firstItemWeight +
                        getBackpackOptimalWeight(
                                items,
                                maximumBackpackWeight - firstItemWeight,
                                firstItemIndex + 1
                        )
                : 0;

        int valueIfTheFirstItemIsNotPacked = getBackpackOptimalWeight(
                items,
                maximumBackpackWeight,
                firstItemIndex + 1
        );

        return Math.max(valueIfTheFirstItemIsPacked, valueIfTheFirstItemIsNotPacked);
    }
}
