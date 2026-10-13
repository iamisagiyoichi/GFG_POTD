class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(0);
        }

        for (int i : updates) {
            ans.set(i - 1, ans.get(i - 1) + 1);
        }

        for (int i = 1; i < n; i++) {
            ans.set(i, ans.get(i - 1) + ans.get(i));
        }

        return ans;
    }
}
