class Solution {
    public int dominantPairs(int[] arr) {
        int N = arr.length;
        int n = N / 2;
        
        int[] tmp1 = new int[n];
        int[] tmp2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            tmp1[i] = arr[i];
        }
        
        for (int i = n; i < N; i++) {
            tmp2[i - n] = arr[i];
        }
        
        Arrays.sort(tmp1);
        
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            int j = lowerBound(tmp1, 5L * tmp2[i]);
            cnt += n - j;
        }
        
        return cnt;
    }
    
    private int lowerBound(int[] arr, long target) {
        int low = 0;
        int high = arr.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
