import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    public static void maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int startIndex = 0, endIndex = 0;
        int tempIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (maxEndingHere + arr[i] > arr[i]) {
                maxEndingHere += arr[i];
            } else {
                maxEndingHere = arr[i];
                tempIndex = i;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                startIndex = tempIndex;
                endIndex = i;
            }
        }
        System.out.println("Maximum subarray sum is " + maxSoFar);
        System.out.println("Starting index of subarray is " + startIndex);
        System.out.println("Ending index of subarray is " + endIndex);
    }
    public static void main(String[] args) {
        int MAX_ARRAY_SIZE = 50;
        int[] arr = new int[MAX_ARRAY_SIZE];
        for (int i=0; i<MAX_ARRAY_SIZE; i++) {
            arr[i] = (int) ((Math.random() * 1000.0) - 500.0);
        }
        System.out.println(arr.toString());
        maxSubArraySum(arr);
    }
}
