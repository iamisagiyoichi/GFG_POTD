class Solution {
    public int countWithout(int n, int d) {
        String s = String.valueOf(n);
        int[][][] dp = new int[s.length()][2][2];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 1, 0, s, d, dp) - 1;
    }

    private int solve(int pos, int tight, int started, String s, int d, int[][][] dp) {
        if (pos == s.length()) return 1;

        if (dp[pos][tight][started] != -1) {
            return dp[pos][tight][started];
        }

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        int ans = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newStarted = (started == 1 || digit != 0) ? 1 : 0;

            if (newStarted == 1 && digit == d) {
                continue;
            }

            ans += solve(pos + 1, newTight, newStarted, s, d, dp);
        }

        return dp[pos][tight][started] = ans;
    }
}
