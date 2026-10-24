class Solution {
    public boolean isPossible(int n, int m, String s) {
        int x = 0, y = 0;
        int minX = 0, maxX = 0, minY = 0, maxY = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') y--;
            else if (c == 'R') y++;
            else if (c == 'D') x--;
            else if (c == 'U') x++;

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        return (maxX - minX < n) && (maxY - minY < m);
    }
}
