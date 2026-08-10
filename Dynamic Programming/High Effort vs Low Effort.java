class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        int[] dp = new int[n + 1];
        dp[1] = Math.max(h[0], l[0]);
        for (int i = 2; i <= n; i++) {
            int low = dp[i - 1] + l[i - 1];
            int high = dp[i - 2] + h[i - 1];
            int nothing = dp[i - 1];
            dp[i] = Math.max(nothing, Math.max(low, high));
        }
        return dp[n];
    }
}
