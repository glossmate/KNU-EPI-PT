import java.util.*;
public class Main_BACK {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 7}; // 중복된 수가 존재하는 리스트
        List<List<Integer>> permutations = permute(nums);
        System.out.println(permutations);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 순열을 구하기 위해 정렬

        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) { // 순열 완성
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue; // 중복된 숫자 처리
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
