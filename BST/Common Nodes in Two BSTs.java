class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node c1 = r1;
        Node c2 = r2;

        while (c1 != null || c2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (c1 != null) {
                s1.push(c1);
                c1 = c1.left;
            }

            while (c2 != null) {
                s2.push(c2);
                c2 = c2.left;
            }

            if (s1.isEmpty() || s2.isEmpty()) break;

            c1 = s1.peek();
            c2 = s2.peek();

            if (c1.data == c2.data) {
                ans.add(c1.data);
                s1.pop();
                s2.pop();
                c1 = c1.right;
                c2 = c2.right;
            }
            else if (c1.data < c2.data) {
                s1.pop();
                c1 = c1.right;
                c2 = null;
            }
            else {
                s2.pop();
                c2 = c2.right;
                c1 = null;
            }
        }

        return ans;
    }
}
