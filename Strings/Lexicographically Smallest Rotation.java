class Solution {
    public String lexiString(String s) {
        int n = s.length();
        String t = s + s;
        int i = 0, j = 1, k = 0;

        while (i < n && j < n && k < n) {
            if (t.charAt(i + k) == t.charAt(j + k)) {
                k++;
            } else if (t.charAt(i + k) > t.charAt(j + k)) {
                i = i + k + 1;
                if (i == j) i++;
                k = 0;
            } else {
                j = j + k + 1;
                if (i == j) j++;
                k = 0;
            }
        }

        int start = Math.min(i, j);
        return t.substring(start, start + n);
    }
}
