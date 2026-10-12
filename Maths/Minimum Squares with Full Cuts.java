
class Solution {
    public int minSquares(int n, int m) {
        int ans = 0;
        while (n > 0 && m > 0) {
            if (n < m) {
                ans += m / n;
                m %= n;
            } else {
                ans += n / m;
                n %= m;
            }
        }
        return ans;
    }
}
