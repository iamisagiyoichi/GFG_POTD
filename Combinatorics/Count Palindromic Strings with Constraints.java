class Solution {
    long mod = 1000000007L;

    public int palindromicStrings(int n, int k) {
        if (n == 1) return k;

        long ans = k + k;

        long prev = k, p = 1;

        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                ans += prev;
                ans %= mod;
            } else {
                ans += ((k - p) * prev) % mod;
                ans %= mod;
                prev = ((k - p) * prev) % mod;
                p++;
            }
        }

        return (int) (ans % mod);
    }
}
