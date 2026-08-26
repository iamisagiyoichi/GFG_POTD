class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        long[] dist = new long[V];

        for (int i = 0; i < V; i++) {
            boolean changed = false;

            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    changed = true;

                    if (i == V - 1) return true;
                }
            }

            if (!changed) return false;
        }

        return false;
    }
}
