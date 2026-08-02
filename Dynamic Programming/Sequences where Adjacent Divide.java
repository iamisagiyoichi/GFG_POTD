class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int last = 1; last <= m; last++) {
                if (dp[len - 1][last] == 0) continue;

                for (int nxt = 1; nxt <= m; nxt++) {
                    if (last % nxt == 0 || nxt % last == 0) {
                        dp[len][nxt] += dp[len - 1][last];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += dp[n][i];
        }

        return ans;
    }
}
