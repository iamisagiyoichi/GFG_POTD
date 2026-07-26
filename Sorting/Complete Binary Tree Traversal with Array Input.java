class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int n = arr.length;
        int i = 0;
        int sz = 1;
        
        while (i < n) {
            ArrayList<Integer> level = new ArrayList<>();
            
            for (int j = 0; j < sz && i < n; j++) {
                level.add(arr[i++]);
            }
            
            Collections.sort(level);
            ans.add(level);
            sz *= 2;
        }
        
        return ans;
    }
}
