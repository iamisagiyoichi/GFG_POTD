import java.util.ArrayList;

class Solution {
    private int[] tree;

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void build(int node, int start, int end, int[] arr) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, arr);
        build(2 * node + 1, mid + 1, end, arr);
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftGcd = query(2 * node, start, mid, l, r);
        int rightGcd = query(2 * node + 1, mid + 1, end, l, r);
        return gcd(leftGcd, rightGcd);
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        tree = new int[4 * n];
        build(1, 0, n - 1, arr);

        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 0) {
                result.add(query(1, 0, n - 1, q[1], q[2]));
            } else if (q[0] == 1) {
                update(1, 0, n - 1, q[1], q[2]);
            }
        }
        return result;
    }
}
