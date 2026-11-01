class Solution {
    public int maximumSubarray(int[] arr) {
        int noSquare = arr[0];
        int oneSquare = arr[0] * arr[0];
        int ans = oneSquare;

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            oneSquare = Math.max(
                x * x,
                Math.max(noSquare + x * x, oneSquare + x)
            );

            noSquare = Math.max(x, noSquare + x);

            ans = Math.max(ans, Math.max(noSquare, oneSquare));
        }

        return ans;
    }
}
