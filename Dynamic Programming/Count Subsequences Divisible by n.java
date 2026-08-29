class Solution {
    public int countSubsequences(String s, int n) {
        final long MOD = 1000000007;

        long[] a = new long[n];
        long[] b = new long[n];

        for (char c : s.toCharArray()) {
            int d = c - '0';

            System.arraycopy(a, 0, b, 0, n);

            b[d % n] = (b[d % n] + 1) % MOD;

            for (int r = 0; r < n; r++) {
                int x = (int) ((r * 10L + d) % n);
                b[x] = (b[x] + a[r]) % MOD;
            }

            long[] t = a;
            a = b;
            b = t;
        }

        return (int) a[0];
    }
}
