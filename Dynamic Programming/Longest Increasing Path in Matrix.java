class Solution {
    public int dfs(int i, int j, int[][] matrix, int[][] dp, int n, int m) {
        if (dp[i][j] != 0)
            return dp[i][j];

        int ans = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                matrix[ni][nj] > matrix[i][j]) {
                ans = Math.max(ans, 1 + dfs(ni, nj, matrix, dp, n, m));
            }
        }

        return dp[i][j] = ans;
    }

    public int longIncPath(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, matrix, dp, n, m));
            }
        }

        return ans;
    }
}
