class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = s.length(), m = d.size();

        List<List<int[]>> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            arr.get(d.get(i).charAt(0) - 'a').add(new int[]{i, 0});
        }

        int[] ans = {-1};

        for (int i = 0; i < n; i++) {
            List<int[]> temp = new ArrayList<>();

            for (int[] p : arr.get(s.charAt(i) - 'a')) {
                int x = p[0];
                int y = p[1];

                if (y + 1 == d.get(x).length()) {
                    if (ans[0] == -1 ||
                        d.get(ans[0]).length() < d.get(x).length() ||
                        (d.get(ans[0]).length() == d.get(x).length()
                            && d.get(ans[0]).compareTo(d.get(x)) > 0)) {
                        ans[0] = x;
                    }
                } else if (d.get(x).charAt(y + 1) == s.charAt(i)) {
                    temp.add(new int[]{x, y + 1});
                } else {
                    arr.get(d.get(x).charAt(y + 1) - 'a').add(new int[]{x, y + 1});
                }
            }

            arr.set(s.charAt(i) - 'a', temp);
        }

        return ans[0] == -1 ? "" : d.get(ans[0]);
    }
}
