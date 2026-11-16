class Solution {
    int findKthSmall(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = k;

        for (int x : arr) {
            if (x <= ans) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
}
