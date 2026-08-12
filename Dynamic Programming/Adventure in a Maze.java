class Solution {
	
	final int MOD = 1_000_000_007;
	
	class Pair {
		int totalPath;
		int maxAd;
		
		Pair(int totalPath, int maxAd) {
			this.totalPath = totalPath;
			this.maxAd = maxAd;
		}
	}
	
	private Pair solve(int r, int c, int n, int m, int grid[][], Pair dp[][]) {
		if (r >= n || c >= m) {
			return new Pair(0, 0);
		}
		
		if (r == n - 1 && c == m - 1) {
			return new Pair(1, grid[r][c]);
		}
		
		if (dp[r][c] != null) {
			return dp[r][c];
		}
		
		int move = grid[r][c];
		
		// Move right
		if (move == 1) {
			Pair right = solve(r, c + 1, n, m, grid, dp);
			int maxAd = 0;
			// If the path reaches to exit door, then consider the max Adventure of the path
			if (right.totalPath > 0) {
				maxAd = right.maxAd;
			}
			return dp[r][c] = new Pair(right.totalPath % MOD, maxAd + grid[r][c]);
		} else if (move == 2) {   // Move down
			Pair down = solve(r + 1, c, n, m, grid, dp);
			int maxAd = 0;
			// If the path reaches to exit door, then consider the max Adventure of the path
			if (down.totalPath > 0) {
				maxAd = down.maxAd;
			}
			return dp[r][c] = new Pair(down.totalPath % MOD, maxAd + grid[r][c]);
		}
		
		// If move = 3, Explore both the directions right and down
		Pair right = solve(r + 1, c, n, m, grid, dp);
		Pair down = solve(r, c + 1, n, m, grid, dp);
		
		int maxAd = 0;
		
		// If the path reaches to exit door, then consider the max Adventure of the path
		if (right.totalPath > 0 && down.totalPath > 0) {
			maxAd = Math.max(right.maxAd, down.maxAd);
		} else if (right.totalPath > 0) {
			maxAd = right.maxAd;
		} else {
			maxAd = down.maxAd;
		}
		
		return dp[r][c] = new Pair((right.totalPath + down.totalPath) % MOD, maxAd + grid[r][c]);
	}
	
	public ArrayList<Integer> findWays(int[][] grid) {
		// Code here
		int n = grid.length;
		int m = grid[0].length;
		
		Pair dp[][] = new Pair[n][m];
		
		for (int i = 0; i<n; i++) {
			Arrays.fill(dp[i], null);
		}
		
		Pair ans = solve(0, 0, n, m, grid, dp);
		
		if (ans.totalPath == 0) {
			return new ArrayList<>(Arrays.asList(0, 0));
		}
		
		return new ArrayList<>(Arrays.asList(ans.totalPath % MOD, ans.maxAd));
	}
}
