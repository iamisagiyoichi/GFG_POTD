```
class Solution {
    public int getCount(int n) {
        int count = 0;
        int twoN = 2 * n;
        for (int k = 2; (long) k * (k + 1) <= twoN; k++) {
            if (twoN % k == 0) {
                int t = twoN / k - k + 1;
                if (t > 0 && (t & 1) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
```
