class Solution {
    public int maxValue(int n) {
        int[] temp = new int[32];
        int index = 31, cnt = 0, res = 0;

        while (n > 0) {
            temp[index--] = n % 2;
            n /= 2;
        }

        for (int i = 0; i < 32; i++) {
            if (temp[i] == 1)
                cnt++;
            else
                cnt = 0;

            if (cnt == 3) {
                temp[i] = 0;
                cnt = 0;
            }
        }

        long k = 1;
        for (int i = 31; i >= 0; i--) {
            res += (int) (temp[i] * k);
            k *= 2;
        }

        return res;
    }
}
