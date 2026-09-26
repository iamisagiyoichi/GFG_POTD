class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int[] dp = new int[x + 1];
        
        for (int i = 1; i <= x; i++) {
            dp[i] = 1000000000;
        }
        
        for (int i = 1; i <= x; i++) {
            int costS = cs + dp[Math.max(0, i - s)];
            int costM = cm + dp[Math.max(0, i - m)];
            int costL = cl + dp[Math.max(0, i - l)];
            
            dp[i] = Math.min(costS, Math.min(costM, costL));
        }
        
        return dp[x];
    }
}
