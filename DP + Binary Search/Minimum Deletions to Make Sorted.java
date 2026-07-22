import java.util.*;

class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int len = 0;

        for (int x : arr) {
            int idx = Arrays.binarySearch(lis, 0, len, x);
            if (idx < 0) idx = -(idx + 1);
            lis[idx] = x;
            if (idx == len) len++;
        }

        return n - len;
    }
}
