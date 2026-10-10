class Solution {
    public boolean balancePan(int a, int b) {
        long current = b;
        long base = a;

        while (current > 0) {
            long rem = current % base;
            if (rem == 0) {
                current /= base;
            } else if (rem == 1) {
                current /= base;
            } else if (rem == base - 1) {
                current = (current + 1) / base;
            } else {
                return false;
            }
        }
        return true;
    }
}
