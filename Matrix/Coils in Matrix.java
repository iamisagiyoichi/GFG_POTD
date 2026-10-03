import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int size = 4 * n;
        int total = size * size;

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (int ring = 0; ring < size / 2; ring++) {
            int lo = ring;
            int hi = size - 1 - ring;

            if ((ring & 1) == 0) {
                for (int r = lo; r <= hi; r++) {
                    first.add(r * size + lo + 1);
                }

                for (int c = lo + 1; c < hi; c++) {
                    first.add(hi * size + c + 1);
                }
            } else {
                for (int r = hi; r >= lo; r--) {
                    first.add(r * size + hi + 1);
                }

                for (int c = hi - 1; c > lo; c--) {
                    first.add(lo * size + c + 1);
                }
            }
        }

        for (int value : first) {
            second.add(total + 1 - value);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(first);
        ans.add(second);

        return ans;
    }
}
