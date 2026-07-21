class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] bestEnd = new int[n];
        int[] maxReach = new int[26];

        for (int i = 0; i < 26; i++) {
            maxReach[i] = -1;
        }

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';

            if (ch == 25 || maxReach[ch + 1] == -1) {
                bestEnd[i] = i;
            } else {
                bestEnd[i] = maxReach[ch + 1];
            }

            maxReach[ch] = Math.max(maxReach[ch], bestEnd[i]);

            if (ch == 0) {
                ans = Math.max(ans, bestEnd[i] - i);
            }
        }

        return ans;
    }
}
