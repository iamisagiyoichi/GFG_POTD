
class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int leftMax = Integer.MIN_VALUE;
        int[] rightMin = new int[n];

        rightMin[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(arr[i + 1], rightMin[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > leftMax && arr[i] < rightMin[i]) {
                ans++;
            }
            leftMax = Math.max(leftMax, arr[i]);
        }

        return ans;
    }
}
