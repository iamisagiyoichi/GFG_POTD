
class Solution {
    static final long MOD = 1_000_000_007L;

    static long F(long x, long a, long b) {
        if (x <= a) return x;

        long c = a - b;
        long cycles = (x - a + c - 1) / c;

        return x + 2 * b * cycles;
    }

    static long prefix(long n, long c) {
        if (n < 0) return 0;

        long m = n / c;
        long rem = n % c;

        return c * m * (m - 1) / 2 + m * (rem + 1);
    }

    static long sumF(long L, long R, long a, long b) {
        if (L > R) return 0;

        long ans = 0;

        long end = Math.min(R, a);

        if (L <= end) {
            long n = end - L + 1;
            long sum = (L + end) * n / 2;
            ans = sum % MOD;
        }

        long start = Math.max(L, a + 1);

        if (start <= R) {
            long n = R - start + 1;
            long sumX = (start + R) * n / 2;

            long c = a - b;
            long sumCeil = n
                    + prefix(R - a - 1, c)
                    - prefix(start - a - 2, c);

            long extra = (2 * b % MOD)
                    * (sumCeil % MOD) % MOD;

            ans = (ans + sumX % MOD + extra) % MOD;
        }

        return ans;
    }

    public int minTime(int a, int b, int d, int l, int r) {
        long normal = F(d, a, b);

        long low = l;
        long high = r;
        long first = r + 1L;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (1 + F(d - mid, a, b) <= normal) {
                first = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        long countNormal = first - l;

        long ans = (countNormal % MOD)
                * (normal % MOD) % MOD;

        if (first <= r) {
            long L = d - r;
            long R = d - first;

            long jumpSum = sumF(L, R, a, b);
            long countJump = r - first + 1;

            ans = (ans + jumpSum + countJump) % MOD;
        }

        return (int) ans;
    }
}
