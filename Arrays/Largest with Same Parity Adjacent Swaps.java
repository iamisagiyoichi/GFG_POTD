class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int j = i;

            while (j < n && arr[j] % 2 == arr[i] % 2) {
                j++;
            }

            Arrays.sort(arr, i, j);

            for (int l = i, r = j - 1; l < r; l++, r--) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }

            i = j;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : arr) {
            ans.add(num);
        }

        return ans;
    }
}
