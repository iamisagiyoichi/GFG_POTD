class Solution {
    int[] parent, size;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void unionSet(int u, int v, long[] paths) {
        u = find(u);
        v = find(v);

        if (u == v) return;

        if (size[u] < size[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        paths[0] += (long) size[u] * size[v];

        parent[v] = u;
        size[u] += size[v];
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int m = queries.length;
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(m, 0));
        long[] paths = {0};
        int j = 0;

        for (int[] query : q) {
            int limit = query[0];
            int idx = query[1];

            while (j < edges.length && edges[j][2] <= limit) {
                unionSet(edges[j][0], edges[j][1], paths);
                j++;
            }

            ans.set(idx, (int) paths[0]);
        }

        return ans;
    }
}
