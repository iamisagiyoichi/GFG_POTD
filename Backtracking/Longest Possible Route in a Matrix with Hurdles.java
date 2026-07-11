class Solution {
    int n, m;
    boolean[][] vis;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;
        vis = new boolean[n][m];
        int ans = dfs(mat, xs, ys, xd, yd);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
    private int dfs(int[][] mat, int x, int y, int xd, int yd) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return Integer.MIN_VALUE;
        if (mat[x][y] == 0 || vis[x][y])
            return Integer.MIN_VALUE;
        if (x == xd && y == yd)
            return 0;
        vis[x][y] = true;
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            max = Math.max(max, dfs(mat, nx, ny, xd, yd));
        }
        vis[x][y] = false;
        if (max == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return max + 1;
    }
}
