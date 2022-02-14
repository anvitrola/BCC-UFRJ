import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Backpack {
    private static Map<Id, Integer> memo;
    public static int getBetterBackpack (List<WeightAndValue> items, int maximumBackpackWeight) {
        initializeMemo();
        return getBackpackOptimalWeight(items, maximumBackpackWeight, 0);
    }

    private static int getBackpackOptimalWeight (List<WeightAndValue> items, int maximumBackpackWeight, int firstItemIndex) {
        if(firstItemIndex >= items.size()) return 0;

        //MEMOIZATION TECHNIQUE STEP 1: check if there's a result in memo for the same keys
        Integer storedValue = findElementInMemo(maximumBackpackWeight, firstItemIndex);
        if(storedValue != null) return storedValue;

        final int firstItemWeight = items.get(firstItemIndex).getWeight();
        final int firstItemValue = items.get(firstItemIndex).getValue();

        int valueIfTheFirstItemIsPacked =
                firstItemWeight <= maximumBackpackWeight
                        ? firstItemValue +
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

        int optimalValue = Math.max(valueIfTheFirstItemIsPacked, valueIfTheFirstItemIsNotPacked);
        //STEP 2: store the result you have just calculated
        putInMemo(maximumBackpackWeight, firstItemIndex, optimalValue);

        return optimalValue;
    }

    private static void initializeMemo () {
        memo = new HashMap<>();
    }

    private static Integer findElementInMemo (int row, int column) {
        return memo.get(new Id(row, column));
    }

    private static void putInMemo (int row, int column, int value) {
        memo.put(new Id(row, column), value);
    }

    private static class Id {
        int maximumBackpackWeight;
        int firstItemIndex;

        public Id (int maximumBackpackWeight, int firstItemIndex) {
            this.maximumBackpackWeight = maximumBackpackWeight;
            this.firstItemIndex = firstItemIndex;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return true;
            Id that = (Id) obj;
            return maximumBackpackWeight == that.maximumBackpackWeight && firstItemIndex == that.firstItemIndex;

        }

        @Override
        public int hashCode() {
            return Objects.hash(maximumBackpackWeight, firstItemIndex);
        }
    }
}
