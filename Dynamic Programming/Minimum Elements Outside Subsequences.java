class Solution {
    int n;
    int[] a;
    int[][][] dp;

    int solve(int i, int inc, int dec) {
        if (i == n) return 0;

        if (dp[i][inc + 1][dec + 1] != -1)
            return dp[i][inc + 1][dec + 1];

        int ans = 1 + solve(i + 1, inc, dec);

        if (inc == -1 || a[i] > a[inc])
            ans = Math.min(ans, solve(i + 1, i, dec));

        if (dec == -1 || a[i] < a[dec])
            ans = Math.min(ans, solve(i + 1, inc, i));

        return dp[i][inc + 1][dec + 1] = ans;
    }

    public int minCount(int[] arr) {
        a = arr;
        n = arr.length;
        dp = new int[n][n + 1][n + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j <= n; j++)
                java.util.Arrays.fill(dp[i][j], -1);

        return solve(0, -1, -1);
    }
}
