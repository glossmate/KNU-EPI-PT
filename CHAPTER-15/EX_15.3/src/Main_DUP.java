import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_DUP {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[A.size()];
        directedPermutations(0 , A, used, result);
        return result;
    }
    private static void directedPermutations(int i, List<Integer> A,
                                             boolean[] used,
                                             List<List<Integer>> result) {
        if (i == A.size() - 1) {
            result.add(new ArrayList <>(A));
            return ;
        }
// Try every possibility for A[i].
        for (int j = i; j < A.size(); ++j) {
            if (used[i] || (i > 0 && A.get(i) == A.get(j) && !used[j])) {
                continue; // 중복된 숫자 처리
            }
            used[i] = true;
            Collections.swap(A , i, j);
// Generate all permutations for A.subList(i + 1, A.size()).
            directedPermutations(i + 1, A, used, result);
            Collections.swap(A , i, j);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<Integer> prob = new ArrayList<>();
        prob.add(2);
        prob.add(2);
        prob.add(5);
        prob.add(7);

        List<List<Integer>> perm = permutations(prob);
        System.out.println("All permutations " + perm );
    }
}