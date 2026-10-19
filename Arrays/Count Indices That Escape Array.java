class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length, ans = 0;
        int[] state = new int[n];

        for (int i = 0; i < n; i++) {
            if (state[i] != 0) continue;

            List<Integer> path = new ArrayList<>();
            int curr = i;

            while (curr >= 0 && curr < n && state[curr] == 0) {
                state[curr] = 1;
                path.add(curr);
                curr += arr[curr];
            }

            int result = (curr < 0 || curr >= n || state[curr] == 2) ? 2 : 1;

            for (int j : path) {
                state[j] = result;
            }

            if (result == 2) {
                ans += path.size();
            }
        }

        return ans;
    }
}
