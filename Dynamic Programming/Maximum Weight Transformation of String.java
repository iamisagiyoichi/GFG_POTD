class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int prev2 = 0, prev1 = 0;

        for (int i = 0; i < n - 1; i++) {
            int gain = (s.charAt(i) == s.charAt(i + 1)) ? 1 : 2;
            int curr = Math.max(prev1, prev2 + gain);
            prev2 = prev1;
            prev1 = curr;
        }

        return n + prev1;
    }
}
