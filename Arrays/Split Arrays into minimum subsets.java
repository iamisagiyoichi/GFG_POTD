import java.util.Arrays;

class Solution {
    int minSubsets(int arr[]) {
        Arrays.sort(arr);
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1] + 1) c++;
        }
        return c;
    }
}
