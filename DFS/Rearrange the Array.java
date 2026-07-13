class Solution {
    static final int MOD = 1000000007;

    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        int[] maxExp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;
                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1;
                    len++;
                }

                int x = len;
                for (int p = 2; p * p <= x; p++) {
                    if (x % p == 0) {
                        int cnt = 0;
                        while (x % p == 0) {
                            x /= p;
                            cnt++;
                        }
                        maxExp[p] = Math.max(maxExp[p], cnt);
                    }
                }
                if (x > 1) {
                    maxExp[x] = Math.max(maxExp[x], 1);
                }
            }
        }

        long ans = 1;
        for (int p = 2; p <= n; p++) {
            if (maxExp[p] > 0) {
                ans = (ans * modPow(p, maxExp[p])) % MOD;
            }
        }

        return (int) ans;
    }

    long modPow(long a, int e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }
}
