class Solution {
    private long countAtMost(int[] arr, long k) {
        if (k < 0) return 0;
        int n = arr.length;
        int left = 0;
        long sum = 0;
        long ans = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public int countSubarray(int[] arr, int l, int r) {
        return (int)(countAtMost(arr, r) - countAtMost(arr, (long)l - 1));
    }
}
