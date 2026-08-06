class Solution {
    public int countMinOperations(int arr[]) {
        int increments = 0;
        int doubles = 0;

        for (int x : arr) {
            increments += Integer.bitCount(x);

            if (x > 0) {
                doubles = Math.max(doubles, 31 - Integer.numberOfLeadingZeros(x));
            }
        }

        return increments + doubles;
    }
}
