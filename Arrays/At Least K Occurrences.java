class Solution {
    public int firstElementKTime(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            
            if (freq.get(x) == k) {
                return x;
            }
        }
        
        return -1;
    }
}
