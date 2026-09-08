class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != word.charAt(0)) continue;

                boolean found = false;

                for (int d = 0; d < 8; d++) {
                    int x = i;
                    int y = j;
                    int k;

                    for (k = 0; k < word.length(); k++) {
                        if (x < 0 || x >= n || y < 0 || y >= m ||
                            mat[x][y] != word.charAt(k)) {
                            break;
                        }

                        x += dx[d];
                        y += dy[d];
                    }

                    if (k == word.length()) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    ans.add(pos);
                }
            }
        }

        return ans;
    }
}
