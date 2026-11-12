class Solution {
    int minDiff(Node root, int k) {
        int ans = Integer.MAX_VALUE;

        while (root != null) {
            ans = Math.min(ans, Math.abs(root.data - k));

            if (root.data == k)
                return 0;

            if (root.data > k)
                root = root.left;
            else
                root = root.right;
        }

        return ans;
    }
}
