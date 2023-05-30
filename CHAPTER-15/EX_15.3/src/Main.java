import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        directedPermutations(0 , A, result);
        return result;
    }
    private static void directedPermutations(int i, List<Integer> A,
                                             List<List<Integer>> result) {
        if (i == A.size() - 1) {
            result.add(new ArrayList <>(A));
            return ;
        }
// Try every possibility for A[i].
        for (int j = i; j < A.size(); ++j) {
            Collections.swap(A , i, j);
// Generate all permutations for A.subList(i + 1, A.sizeO).
            directedPermutations(i + 1, A, result);
            Collections.swap(A , i, j);
        }
    }

    public static void main(String[] args) {
        List<Integer> prob = new ArrayList<>();
        prob.add(2);
        prob.add(3);
        prob.add(5);
        prob.add(7);

        List<List<Integer>> perm = permutations(prob);
        System.out.println("Hello world! " + perm );
    }
}