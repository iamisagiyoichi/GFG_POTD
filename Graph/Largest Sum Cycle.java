class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] vis = new int[n];
        int ans = -1, timer = 1;

        for (int i = 0; i < n; i++) {
            if (vis[i] != 0) continue;

            int u = i;

            while (u != -1 && vis[u] == 0) {
                vis[u] = timer;
                u = edge[u];
            }

            if (u != -1 && vis[u] == timer) {
                int sum = 0;
                int v = u;

                do {
                    sum += v;
                    v = edge[v];
                } while (v != u);

                ans = Math.max(ans, sum);
            }

            timer++;
        }

        return ans;
    }
}
