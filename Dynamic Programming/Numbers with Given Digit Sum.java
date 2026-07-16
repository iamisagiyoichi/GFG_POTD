class Solution {
    public int countWays(int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;

        for (int pos = 1; pos <= n; pos++) {
            for (int s = 0; s <= sum; s++) {
                int ways = 0;
                int start = (pos == 1) ? 1 : 0;
                for (int d = start; d <= 9 && d <= s; d++) {
                    ways += dp[pos - 1][s - d];
                }
                dp[pos][s] = ways;
            }
        }

        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}
