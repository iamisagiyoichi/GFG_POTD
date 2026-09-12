class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        long NEG = Long.MIN_VALUE / 4;
        long POS = Long.MAX_VALUE / 4;

        long[][] max = new long[n + 1][k + 1];
        long[][] min = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(max[i], NEG);
            java.util.Arrays.fill(min[i], POS);
        }

        max[0][0] = 1;
        min[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            max[i][0] = 1;
            min[i][0] = 1;

            for (int j = 1; j <= Math.min(i, k); j++) {
                long x = arr[i - 1];

                max[i][j] = max[i - 1][j];
                min[i][j] = min[i - 1][j];

                if (max[i - 1][j - 1] != NEG) {
                    long a = max[i - 1][j - 1] * x;
                    long b = min[i - 1][j - 1] * x;

                    max[i][j] = Math.max(max[i][j], Math.max(a, b));
                    min[i][j] = Math.min(min[i][j], Math.min(a, b));
                }
            }
        }

        return (int) max[n][k];
    }
}
