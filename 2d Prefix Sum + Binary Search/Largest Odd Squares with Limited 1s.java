class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j]
                        + pref[i][j + 1]
                        + pref[i + 1][j]
                        - pref[i][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];

            int maxRadius = Math.min(
                    Math.min(i, j),
                    Math.min(n - 1 - i, m - 1 - j)
            );

            if (mat[i][j] > k) {
                ans.add(-1);
                continue;
            }

            int low = 0;
            int high = maxRadius;
            int best = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                int r1 = i - mid;
                int c1 = j - mid;
                int r2 = i + mid;
                int c2 = j + mid;

                int ones = pref[r2 + 1][c2 + 1]
                        - pref[r1][c2 + 1]
                        - pref[r2 + 1][c1]
                        + pref[r1][c1];

                if (ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ans.add(2 * best + 1);
        }

        return ans;
    }
}
