class Solution {
    public int maxDiffSum(int[] arr) {
        long a = 0;
        long b = 0;

        for (int i = 1; i < arr.length; i++) {
            long na = Math.max(a + Math.abs(arr[i] - arr[i - 1]),
                               b + Math.abs(arr[i] - 1));

            long nb = Math.max(a + Math.abs(1 - arr[i - 1]),
                               b);

            a = na;
            b = nb;
        }

        return (int) Math.max(a, b);
    }
}
