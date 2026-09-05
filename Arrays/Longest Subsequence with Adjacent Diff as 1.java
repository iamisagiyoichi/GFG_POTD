class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : arr) {
            int left = dp.getOrDefault(x - 1, 0);
            int right = dp.getOrDefault(x + 1, 0);

            int curr = Math.max(left, right) + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), curr));
            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}
