class Solution {
    public void sortIt(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            a[i] = arr[i];

        Arrays.sort(a, (x, y) -> {
            if ((x % 2) != (y % 2))
                return (x % 2 != 0) ? -1 : 1;
            if (x % 2 != 0)
                return Integer.compare(y, x);
            return Integer.compare(x, y);
        });

        for (int i = 0; i < arr.length; i++)
            arr[i] = a[i];
    }
}
