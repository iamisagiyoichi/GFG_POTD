class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(new int[]{v, 0});
            adj.get(v).add(new int[]{u, 1});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        Deque<Integer> dq = new ArrayDeque<>();

        dist[src] = 0;
        dq.addFirst(src);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int cost = edge[1];

                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;

                    if (cost == 0) {
                        dq.addFirst(v);
                    } else {
                        dq.addLast(v);
                    }
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}
