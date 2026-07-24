/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int ans = 0;
    public int longestConsecutive(Node root) {
        if (root == null) return -1;
        dfs(root, 1);
        return ans > 1 ? ans : -1;
    }
    void dfs(Node node, int len) {
        ans = Math.max(ans, len);
        if (node.left != null) {
            if (node.left.data == node.data + 1)
                dfs(node.left, len + 1);
            else
                dfs(node.left, 1);
        }
        if (node.right != null) {
            if (node.right.data == node.data + 1)
                dfs(node.right, len + 1);
            else
                dfs(node.right, 1);
        }
    }
}
