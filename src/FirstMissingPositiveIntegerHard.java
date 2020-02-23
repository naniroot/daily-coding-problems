import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class FirstMissingPositiveIntegerHard {
    public static void main(String args[]) {
        int input[] = new int[]{1,2,0};//new int[]{2, 3, 7, 6, 8, -1, -10, 15};
        FirstMissingPositiveIntegerHard hard = new FirstMissingPositiveIntegerHard();

        int segArr[] = hard.segregate(input);
        System.out.println(hard.findMissing(segArr));

    }

    int findMissing(int arr[]) {
        if(arr.length == 0) return 1;
        for(int i=0; i<arr.length; i++) {
            int term = Math.abs(arr[i]);
            if(term-1 < arr.length && arr[term-1]>0) {
                arr[term-1] = -1 * arr[term-1];
            }
        }
        printArray(arr);
        for(int k=0; k<arr.length; k++) {
            if(arr[k] > 0) {
                return k+1;
            }
        }
        return arr.length+1;
    }

    int[] segregate(int input[]) {
        int j=input.length-1;
        for(int i=input.length-1; i>=0; i--) {
            if(input[i] <= 0) {
                int tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
                j--;
            }
        }
        int sg[] = Arrays.copyOf(input, j+1);
        printArray(sg);
        return sg;
    }

    static void printArray(int input[]) {
        for(int k: input) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}

