public class Main {
    public static int countWays(int n, int k) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                dp[i] += dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5; // 예시 값
        int k = 3; // 예시 값
        int ways = countWays(n, k);
        System.out.println("There are " + ways + " ways to reach step " + n + " using " + k + " steps at a time.");
    }
}
