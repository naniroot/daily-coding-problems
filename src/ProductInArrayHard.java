/**
 * Given an array of integers, return a new array such that each element at index i
 * of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */


public class ProductInArrayHard {

    static int[] getProductInArray(int input[]) {
        int product = 1;
        for(int k: input) {
         product *= k;
        }
        int output[] = new int[input.length];
        for(int i=0; i<input.length; i++) {
            output[i] = product/input[i];
        }
        return output;
    }

    static int[] getProductNoDivision(int input[]) {
        int output[] = new int[input.length];

        int product = 1;
        for(int i=0; i<input.length; i++) {
            output[i] = product;
            product *= input[i];
        }

        product = 1;
        for(int i=input.length-1; i>=0; i--){
            output[i] = product * output[i];
            product *= input[i];
        }
        return output;
    }

    static void printResult(int res[]) {
        for(int k: res) {
            System.out.print(k + " ");
        }
    }

    public static void main(String args[]) throws Exception {
        //int input[] = new int[]{3, 2, 1};
        int input[] = new int[]{1, 2, 3, 4, 5};
//        int input[] = new int[]{1, 0};
//        printResult(getProductInArray(input));
        printResult(getProductNoDivision(input));

    }
}
