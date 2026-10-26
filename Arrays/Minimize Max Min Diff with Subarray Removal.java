
class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        if (k == n) return 0;

        int[][] right = new int[n][2];
        int[][] left = new int[n][2];
        int ans = Integer.MAX_VALUE;

        right[n - 1][0] = arr[n - 1];
        right[n - 1][1] = arr[n - 1];
        left[0][0] = arr[0];
        left[0][1] = arr[0];

        for (int i = 1; i < n; i++) {
            left[i][0] = Math.max(left[i - 1][0], arr[i]);
            left[i][1] = Math.min(left[i - 1][1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i][0] = Math.max(right[i + 1][0], arr[i]);
            right[i][1] = Math.min(right[i + 1][1], arr[i]);
        }

        ans = Math.min(ans, right[k][0] - right[k][1]);
        ans = Math.min(ans, left[n - k - 1][0] - left[n - k - 1][1]);

        int l = 0;
        int r = k + 1;

        while (r < n) {
            int maxi = Math.max(left[l][0], right[r][0]);
            int mini = Math.min(left[l][1], right[r][1]);
            ans = Math.min(ans, maxi - mini);
            l++;
            r++;
        }

        return ans;
    }
}
