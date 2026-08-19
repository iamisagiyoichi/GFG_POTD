class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        return count(arr, r) - count(arr, l - 1);
    }

    public int count(int[] arr, int target) {
        int n = arr.length;
        long ans = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum <= target) {
                    ans += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return (int) ans;
    }
}
