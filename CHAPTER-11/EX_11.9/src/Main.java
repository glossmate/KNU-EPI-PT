import java.util.BitSet;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 90, 70, 70, 71, 72, 73, 74,
                75, 76, 89, 78, 79, 80, 55, 82, 83, 84, 85, 44, 87, 88, 89, 90, 91, 92, 93,
                94, 95, 96, 97, 98, 99, 100};
        int totalNumbers = 100;
        BitSet numbersBitSet = new BitSet(totalNumbers);

        for (int num : numbers) {
            if (numbersBitSet.get(num - 1)) {
                System.out.println(num + " is a duplicate.");
            } else {
                numbersBitSet.set(num - 1);
            }
        }

        System.out.println("Missing numbers are:");
        for (int i = 0; i < totalNumbers; i++) {
            if (!numbersBitSet.get(i)) {
                System.out.println(i + 1);
            }
        }
    }
}
