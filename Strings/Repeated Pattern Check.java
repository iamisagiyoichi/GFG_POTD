class Solution {
    public boolean findPattern(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) != 'x') return false;

            int cntX = 0;
            while (i < n && s.charAt(i) == 'x') {
                cntX++;
                i++;
            }

            int cntY = 0;
            while (i < n && s.charAt(i) == 'y') {
                cntY++;
                i++;
            }

            if (cntX != cntY) return false;
        }

        return true;
    }
}
