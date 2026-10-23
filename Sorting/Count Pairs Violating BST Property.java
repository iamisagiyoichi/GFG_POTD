/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    long ans = 0;

    void inorder(Node root, java.util.List<Integer> a) {
        if (root == null) return;
        inorder(root.left, a);
        a.add(root.data);
        inorder(root.right, a);
    }

    void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                ans += mid - i + 1;
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];

        for (i = l; i <= r; i++) {
            a[i] = temp[i - l];
        }
    }

    public int pairsViolatingBST(Node root) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        inorder(root, list);

        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }

        ans = 0;
        mergeSort(a, 0, a.length - 1);
        return (int) ans;
    }
}
