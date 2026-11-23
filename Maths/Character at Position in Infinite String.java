import java.util.*;

class Solution {
    public char posInfinite(String s, int pos) {
        long len = s.length();
        long target = pos;
        long step = 0;

        while (len < target) {
            step++;
            len = 2 * len + step;
        }

        while (target > s.length()) {
            long prevLen = (len - step) / 2;

            if (target > prevLen && target <= prevLen + step) {
                return '$';
            }

            if (target > prevLen + step) {
                target = len - target + 1;
            }

            len = prevLen;
            step--;
        }

        return s.charAt((int) target - 1);
    }
}
