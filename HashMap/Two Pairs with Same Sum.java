class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        HashMap<Long, int[]> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(-1, -1, -1, -1));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = (long) arr[i] + arr[j];

                if (map.containsKey(sum)) {
                    int[] p = map.get(sum);
                    int a = p[0], b = p[1];

                    if (a != i && a != j && b != i && b != j) {
                        ArrayList<Integer> temp = new ArrayList<>(
                            Arrays.asList(a, b, i, j)
                        );

                        if (ans.get(0) == -1 || compare(temp, ans) < 0) {
                            ans = temp;
                        }
                    }
                } else {
                    map.put(sum, new int[]{i, j});
                }
            }
        }

        return ans;
    }

    private int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < 4; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return 0;
    }
}
