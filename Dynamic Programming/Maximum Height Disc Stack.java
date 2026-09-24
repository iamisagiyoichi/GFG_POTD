class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;

        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = discs[i][1];

            for (int j = 0; j < i; j++) {
                if (discs[j][0] < discs[i][0] &&
                    discs[j][1] < discs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + discs[i][1]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
