import java.util.*;

class Compare {
    private static class GreaterThan implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return (a > b) ? -1 : (a.equals(b)) ? 0 : 1;
        }
    }
    public static final GreaterThan GREATER_THAN = new GreaterThan();
}

/*
sdflkhjasdlkf
dsakjfhlsdhjfjklsdhaf
dsfdsfkdjflajdflsd

*/
public class Main {

    public static int findKthLargest(ArrayList<Integer> A, int k) {
        return findKth(A, k, Compare.GREATER_THAN);
    }

    public static int findKth(ArrayList<Integer> A, int k, Comparator<Integer> cmp) {
        int result = -1;
        int left = 0, right = A.size() - 1;
        Random r = new Random(8);
        while (left <= right) {
            System.out.println(
                    String.format(
                        "[%d, %d]", left, right
                    )
            );
            // Generates a random integer in [left, right].
            int pivotIdx = r.nextInt(right - left + 1) + left;
            int newPivotIdx = partitionAroundPivot(left, right, pivotIdx, A, cmp);
            if (newPivotIdx == k - 1) {
                result = A.get(newPivotIdx);
                break;
            } else if (newPivotIdx > k - 1) {
                right = newPivotIdx - 1;
            } else { // newPivotIdx < k - 1.
                left = newPivotIdx + 1;
            }
        }
        return result;
    }

    private static int partitionAroundPivot(int left, int right, int pivotIdx,
                                            ArrayList<Integer> A,
                                            Comparator<Integer> cmp) {
        int pivotValue = A.get(pivotIdx);
        int newPivotIdx = left;
        System.out.println(
                String.format(
                        "STEP 1 : pivotIdx = %d, pivotValue : %d, newPivotIdx : %d, left : %d, right : %d, %s",
                        pivotIdx, pivotValue, newPivotIdx, left, right, A
                )
        );
        Collections.swap(A, pivotIdx, right);
        System.out.println(
                String.format(
                        "STEP 2 : pivotIdx = %d, pivotValue : %d, newPivotIdx : %d, left : %d, right : %d, %s",
                        pivotIdx, pivotValue, newPivotIdx, left, right, A
                )
        );
        for (int i = left; i < right; ++i) {
            if (cmp.compare(A.get(i), pivotValue) < 0){
                Collections.swap(A, i, newPivotIdx++);
                System.out.println(
                        String.format(
                                "STEP 3 : pivotIdx = %d, pivotValue : %d, newPivotIdx : %d, left : %d, right : %d, %s",
                                pivotIdx, pivotValue, newPivotIdx, left, right, A
                        )
                );
            }
        }
        System.out.println(
                String.format(
                        "STEP 4 : pivotIdx = %d, pivotValue : %d, newPivotIdx : %d, left : %d, right : %d, %s",
                        pivotIdx, pivotValue, newPivotIdx, left, right, A
                )
        );
        Collections.swap(A, right, newPivotIdx);
        System.out.println(
                String.format(
                        "STEP 5 : pivotIdx = %d, pivotValue : %d, newPivotIdx : %d, left : %d, right : %d, %s",
                        pivotIdx, pivotValue, newPivotIdx, left, right, A
                )
        );
        return newPivotIdx;
    }

    public static void main(String[] args) {

        ArrayList<Integer> prob = new ArrayList<>();

        prob.add(5);
        prob.add(3);
        prob.add(1);
        prob.add(6);
        prob.add(8);
        prob.add(0);
        prob.add(9);
        prob.add(7);
        prob.add(2);
        prob.add(4);

        int K_TH = findKthLargest(prob, 3);
        System.out.println(String.format(" %d", K_TH));
    }
}