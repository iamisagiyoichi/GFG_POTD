class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);

        long sum = 0;
        int l = 0, ans = 1;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];

            while (1L * arr[r] * (r - l + 1) - sum > k) {
                sum -= arr[l++];
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
