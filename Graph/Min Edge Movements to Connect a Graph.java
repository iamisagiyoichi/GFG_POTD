class Solution {
    int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;

        if (m < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu != pv) {
                if (rank[pu] < rank[pv]) {
                    parent[pu] = pv;
                } else if (rank[pu] > rank[pv]) {
                    parent[pv] = pu;
                } else {
                    parent[pv] = pu;
                    rank[pu]++;
                }

                components--;
            }
        }

        return components - 1;
    }

    int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
