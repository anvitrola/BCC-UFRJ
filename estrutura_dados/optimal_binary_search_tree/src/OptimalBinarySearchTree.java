import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalBinarySearchTree {
    Map<HeadAndTale, Integer> weightMemo;
    Map<HeadAndTale, Integer> rootIndexesMemo;

    public int getOptimalBSTWeight (List<KeyAndFrequency> list) {
        weightMemo = new HashMap<>();
        rootIndexesMemo = new HashMap<>();

        //the "original" call. in the main call example: 0...49
        return getOptimalWeight(list, 0, list.size() - 1);
    }

    /*
    * Top-down approach with recursive calls.
    * This method is better than bottom-up, which is not only more difficult to implement, but it also
    * makes us save things we won't use because it will fulfill a whole table that goes from minor to the major interval.
     */
    private int getOptimalWeight(List<KeyAndFrequency> list, int head, int tale) {
        //empty tree case. ex: 0...-1. there's no possible roots between 0 and -1.
        if (head > tale) {
            return 0;
        }

        // In case of unitary tree (0...0, 1...1)
        if(head == tale) {
            return list.get(head).getFrequency();
        }

        HeadAndTale headAndTale = new HeadAndTale(head, tale);

        //checking if this interval was already calculated and saved in memo
        Integer result = weightMemo.get(headAndTale);
        if (result != null) {
            return result;
        }

        /* calculating sum of all nodes inside the head and tale interval.
        * ex: (1..5) -> 1.frequency + 2.frequency + (...) + 5.frequency
        * */
        int allFrequenciesSum = 0;
        for (int i = head; i<= tale; i++) allFrequenciesSum += list.get(i).getFrequency();

        int optimalWeight = Integer.MAX_VALUE;
        Integer optimalRootIndex = null;

        /*
        In this for we're trying to discover the more efficient BST, which is the one that has the
        minimal weight in terms of frequency. To find that, we put all nodes as root and
        recursive calculate the left and right sub-trees to finally compare the total weight of
        having that node as root.

        * So, the original call is: head = 0 and tale = 49
        * The optimal weight of a BST is calculated through the optimal weight of the
        * left subtree (head...head-1) + the optimal weight of right subtree (head+1...tale) + sum of all frequencies
        *
        * So, the recursion in the original call would be:
        * left subtree = (head: 0, tale: -1) --> return 0
        * right subtree = (head: 1, tale: 48) --> return X
        * sum of all frequencies = Y
        */
        for(int rootIndex = head; rootIndex <= tale; rootIndex++) {
            int weight = getOptimalWeight(list, head, rootIndex - 1) + getOptimalWeight(list, rootIndex + 1, tale) + allFrequenciesSum;

            if(weight < optimalWeight) {
                optimalWeight = weight;
                optimalRootIndex = rootIndex;
            }
        }

        //Save the best weight we can find for this (head...tale) interval because we will need this for recursion
        weightMemo.put(headAndTale, optimalWeight);
        rootIndexesMemo.put(headAndTale, optimalRootIndex);

        return optimalWeight;
    }

}
