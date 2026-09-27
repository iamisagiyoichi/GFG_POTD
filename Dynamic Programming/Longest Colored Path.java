import java.util.*;

class Solution {
    List<List<Integer>> adj;
    String s;

    void dfs(int node, int par, int[] in) {
        in[node] = 1;
        for (int it : adj.get(node)) {
            if (par == it)
                continue;
            dfs(it, node, in);
            // B -> R is invalid
            if (s.charAt(it) == 'R' && s.charAt(node) == 'B')
                continue;
            in[node] = Math.max(in[node], 1 + in[it]);
        }
    }

    void dfs1(int node, int par, int[] in, int[] out) {
        int take1 = 0;
        int take2 = 0;
        int take1node = -1;

        // Find two best valid child branches
        for (int it : adj.get(node)) {
            if (it == par)
                continue;
            // B -> R is invalid
            if (s.charAt(node) == 'B' && s.charAt(it) == 'R')
                continue;

            int val = in[it];
            if (val > take1) {
                take2 = take1;
                take1 = val;
                take1node = it;
            } else if (val > take2) {
                take2 = val;
            }
        }

        for (int it : adj.get(node)) {
            if (it == par)
                continue;

            int bestoutside = out[node];
            // If it is the best child, use the second best child
            if (it == take1node) {
                bestoutside = Math.max(bestoutside, take2 + 1);
            } else {
                bestoutside = Math.max(bestoutside, take1 + 1);
            }

            // B -> R is invalid
            if (s.charAt(it) == 'B' && s.charAt(node) == 'R') {
                out[it] = 1;
            } else {
                out[it] = bestoutside + 1;
            }

            dfs1(it, node, in, out);
        }
    }

    public int longestPath(String str, int[][] edges) {
        s = str;
        int n = s.length();
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] in = new int[n];
        int[] out = new int[n];

        // First DFS
        dfs(0, -1, in);

        // Root has nothing outside
        out[0] = 0;

        // Rerooting DFS
        dfs1(0, -1, in, out);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, in[i]);
            ans = Math.max(ans, out[i]);
        }

        return ans;
    }
}
