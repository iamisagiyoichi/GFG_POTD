class Solution {
    static final int MOD = 1000000007;

    int cntSubsets(int[] arr, int l, int r) {
        int n = arr.length;
        int[] cnt = new int[n + 1];

        for (int x : arr) {
            if (x <= n) {
                cnt[x]++;
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long ans = 0;
        long ways = 1;
        long remaining = 0;

        for (int i = n; i >= 0; i--) {
            if (i > 0 && cnt[i] > 0) {
                remaining += cnt[i];
            }
        }

        remaining = 0;

        for (int mex = 0; mex <= n; mex++) {
            if (mex > 0) {
                if (cnt[mex - 1] == 0) {
                    break;
                }

                ways = ways * ((pow2[cnt[mex - 1]] - 1 + MOD) % MOD) % MOD;
            }

            if (mex >= l && mex <= r) {
                long rem = 0;

                for (int i = mex + 1; i <= n; i++) {
                    rem += cnt[i];
                }

                long contribution = ways * pow2[(int) rem] % MOD;
                ans = (ans + contribution) % MOD;
            }
        }

        return (int) ans;
    }
}
