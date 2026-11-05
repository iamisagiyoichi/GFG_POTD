class Solution {
    public int getMinimumDays(String s, int[] p) {
        int days = 0;
        int n = p.length;
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int idx = p[i];

            char r = (idx + 1 < n) ? arr[idx + 1] : '$';
            char l = (idx - 1 >= 0) ? arr[idx - 1] : '$';

            if (r == arr[idx] || l == arr[idx]) {
                arr[idx] = '?';
                days = i + 1;
            }
        }

        return days;
    }
}
