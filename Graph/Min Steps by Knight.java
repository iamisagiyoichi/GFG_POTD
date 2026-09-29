class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1])
            return 0;

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        int sx = knightPos[0], sy = knightPos[1];
        int tx = targetPos[0], ty = targetPos[1];

        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;

                    if (nx == tx && ny == ty)
                        return dist[nx][ny];

                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}
