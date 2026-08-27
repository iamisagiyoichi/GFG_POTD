class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] h = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    h[j]++;
                } else {
                    h[j] = 0;
                }
            }

            int[] a = h.clone();
            Arrays.sort(a);

            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, a[m - 1 - j] * (j + 1));
            }
        }

        return ans;
    }
}
