class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length, l = 0, sum = 0, ans = Integer.MAX_VALUE;

        for(int r = 0; r < n; r++) {
            sum += arr[r];

            while(sum > x) {
                ans = Math.min(ans, r - l + 1);
                sum -= arr[l++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
