class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] p = new int[n + 1];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            p[i + 1] = p[i] + (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0);
        }

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            ans.add(p[r + 1] - p[l]);
        }

        return ans;
    }
}
