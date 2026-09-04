class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        long sum = 0;
        long ans = 0;

        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        ans = sum;

        for (int i = m; i < n + m - 1; i++) {
            sum += arr.get(i % n);
            sum -= arr.get((i - m) % n);
            ans = Math.max(ans, sum);
        }

        return (int) ans;
    }
}
