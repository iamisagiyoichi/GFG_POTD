class Solution {
    public int minimumSum(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int k = n / 2;

        for (int i = 0; i < k; i++) {
            if (arr[i] != '?' && arr[n - 1 - i] != '?') {
                if (arr[i] != arr[n - 1 - i])
                    return -1;
            } else if (arr[i] != '?') {
                arr[n - 1 - i] = arr[i];
            } else if (arr[n - 1 - i] != '?') {
                arr[i] = arr[n - 1 - i];
            }
        }

        int res = 0;
        for (int i = 1; i < k; i++) {
            if (arr[i] != '?' && arr[i - 1] != '?')
                res += 2 * Math.abs(arr[i] - arr[i - 1]);
            else if (arr[i] == '?' && arr[i - 1] != '?')
                arr[i] = arr[i - 1];
        }

        if (n % 2 == 1 && arr[k] != '?' && arr[k - 1] != '?')
            res += 2 * Math.abs(arr[k] - arr[k - 1]);

        return res;
    }
}
