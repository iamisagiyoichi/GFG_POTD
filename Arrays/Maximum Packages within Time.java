class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int sum = 0, maxi = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= totalTime)
                sum -= arr[i - totalTime];
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}
