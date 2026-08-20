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
    public void maxDiffHelper(Node root, int maxEle, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.max(ans[0], maxEle - root.data);

        if (root.data > maxEle) {
            maxEle = root.data;
        }

        if (root.left != null)
            maxDiffHelper(root.left, maxEle, ans);

        if (root.right != null)
            maxDiffHelper(root.right, maxEle, ans);
    }

    int maxDiff(Node root) {
        int[] ans = {Integer.MIN_VALUE};

        if (root.left != null)
            maxDiffHelper(root.left, root.data, ans);

        if (root.right != null)
            maxDiffHelper(root.right, root.data, ans);

        return ans[0];
    }
}
