/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public boolean findPath(Node root, int val, ArrayList<Integer> path) {
        if (root == null) return false;

        if (root.data == val) return true;

        path.add(0);
        if (findPath(root.left, val, path)) return true;
        path.remove(path.size() - 1);

        path.add(1);
        if (findPath(root.right, val, path)) return true;
        path.remove(path.size() - 1);

        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {
        ArrayList<Integer> pathP = new ArrayList<>();
        ArrayList<Integer> pathQ = new ArrayList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        int i = 0;

        while (i < pathP.size() && i < pathQ.size()
                && pathP.get(i).equals(pathQ.get(i))) {
            i++;
        }

        ArrayList<Integer> path = new ArrayList<>();

        for (int j = pathP.size() - 1; j >= i; j--) {
            path.add(pathP.get(j));
        }

        for (int j = i; j < pathQ.size(); j++) {
            path.add(pathQ.get(j));
        }

        if (path.size() <= 1) return -1;

        int turns = 0;

        for (int j = 1; j < path.size(); j++) {
            if (!path.get(j).equals(path.get(j - 1))) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }
}
