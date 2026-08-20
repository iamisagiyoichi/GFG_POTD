/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int solve(Node root, int mx) {
        if (root == null) return Integer.MIN_VALUE;

        int ans = mx - root.data;
        mx = Math.max(mx, root.data);

        ans = Math.max(ans, solve(root.left, mx));
        ans = Math.max(ans, solve(root.right, mx));

        return ans;
    }

    int maxDiff(Node root) {
        return solve(root, root.data);
    }
}
