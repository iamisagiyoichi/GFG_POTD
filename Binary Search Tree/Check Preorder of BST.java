class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        int r = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x < r) return false;
            while (!s.isEmpty() && x > s.peek()) {
                r = s.pop();
            }
            s.push(x);
        }
        return true;
    }
}
