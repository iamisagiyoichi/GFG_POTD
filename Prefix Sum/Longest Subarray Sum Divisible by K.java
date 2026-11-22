class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0, ans = 0;

        for(int i = 0; i < arr.length; i++) {
            sum = ((sum + arr[i]) % k + k) % k;

            if(mp.containsKey(sum))
                ans = Math.max(ans, i - mp.get(sum));
            else
                mp.put(sum, i);
        }

        return ans;
    }
}
