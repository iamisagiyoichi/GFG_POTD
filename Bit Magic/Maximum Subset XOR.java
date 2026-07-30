class Solution {
    public int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        int idx = 0;

        for (int b = 31; b >= 0; b--) {
            int mx = -1, id = -1;

            for (int i = idx; i < n; i++) {
                if (((arr[i] >> b) & 1) == 1 && arr[i] > mx) {
                    mx = arr[i];
                    id = i;
                }
            }

            if (id == -1) continue;

            int t = arr[idx];
            arr[idx] = arr[id];
            arr[id] = t;

            for (int i = 0; i < n; i++) {
                if (i != idx && ((arr[i] >> b) & 1) == 1) {
                    arr[i] ^= arr[idx];
                }
            }

            idx++;
        }

        int ans = 0;
        for (int x : arr) ans ^= x;
        return ans;
    }
}
