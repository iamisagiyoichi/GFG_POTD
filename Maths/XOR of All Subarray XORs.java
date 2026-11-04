class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int ans = 0;

        if (n % 2 == 0) return 0;

        for (int i = 0; i < n; i += 2) {
            ans ^= arr[i];
        }

        return ans;
    }
}
