class Solution {
    int solve(Node root, int[] ans) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.data;

        int lSub = solve(root.left, ans);
        int rSub = solve(root.right, ans);

        if (root.left != null && root.right != null) {
            ans[0] = Math.max(ans[0], lSub + rSub + root.data);
            return Math.max(lSub, rSub) + root.data;
        }

        if (root.left != null)
            return lSub + root.data;

        if (root.right != null)
            return rSub + root.data;

        return 0;
    }

    int maxPathSum(Node root) {
        int[] ans = {Integer.MIN_VALUE};

        solve(root, ans);

        if (ans[0] == Integer.MIN_VALUE)
            return -1;

        return ans[0];
    }
}
