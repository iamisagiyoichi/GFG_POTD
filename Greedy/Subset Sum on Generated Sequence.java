class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        long sum = s;
        long[] seq = new long[arr.length + 1];
        seq[0] = s;

        int n = 1;

        for (int i = 0; i < arr.length; i++) {
            long next = sum + arr[i];

            if (next > x) break;

            seq[n++] = next;
            sum += next;
        }

        long target = x;

        for (int i = n - 1; i >= 0; i--) {
            if (seq[i] <= target) {
                target -= seq[i];
            }

            if (target == 0) return true;
        }

        return false;
    }
}
