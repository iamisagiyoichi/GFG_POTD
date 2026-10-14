class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int x : roll) {
            diff[0]++;
            diff[x]--;
        }

        char[] arr = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];
            arr[i] = (char) ((arr[i] - 'a' + sum) % 26 + 'a');
        }

        return new String(arr);
    }
}
