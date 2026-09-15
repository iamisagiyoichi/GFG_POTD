/* Binary Tree Node Structure
class Node {
  public:
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int getCount(Node root, int k) {
        ArrayList<Integer> leaves = new ArrayList<>();
        Queue<Node> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        nodes.offer(root);
        levels.offer(1);

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int level = levels.poll();

            if (node.left == null && node.right == null) {
                leaves.add(level);
            }

            if (node.left != null) {
                nodes.offer(node.left);
                levels.offer(level + 1);
            }

            if (node.right != null) {
                nodes.offer(node.right);
                levels.offer(level + 1);
            }
        }

        Collections.sort(leaves);

        int ans = 0;

        for (int cost : leaves) {
            if (k < cost) break;
            k -= cost;
            ans++;
        }

        return ans;
    }
}
