import java.util.*;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
 * Can you do this in one pass?
 */

public class SumOfTwoInListEasy {
    public static int[] sumOfTwo(int[] input, int sum) {

        int res[] = new int[2];
        Set<Integer> intgerHashSet = new HashSet<>();
        for (int first : input) {
            int second = sum - first;
            if (intgerHashSet.contains(second)) {
                res[0] = first;
                res[1] = second;
                return res;
            } else {
                intgerHashSet.add(first);
            }
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
//        int testArray1[] = new int[]{10, 15, 3, 7};
//        int sum = 17;
        int testArray1[] = new int[]{3, 4, 4, 4, 7, 6};
        int sum = 10;

        int result[] = sumOfTwo(testArray1, sum);
        for(int a: result) {
            System.out.print(a + " ");
        }

    }
}
