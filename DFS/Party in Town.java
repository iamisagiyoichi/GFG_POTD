class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        int[] p1 = bfs(adj, 0, n);
        int[] p2 = bfs(adj, p1[0], n);

        return (p2[1] + 1) / 2;
    }

    int[] bfs(ArrayList<ArrayList<Integer>> adj, int src, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        int far = src;

        while(!q.isEmpty()) {
            int u = q.poll();

            for(int v : adj.get(u)) {
                v--;

                if(dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);

                    if(dist[v] > dist[far])
                        far = v;
                }
            }
        }

        return new int[]{far, dist[far]};
    }
}
