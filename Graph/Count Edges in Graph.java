class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int cnt = 0;
        for (ArrayList<Integer> v : adj) {
            cnt += v.size();
        }
        return cnt / 2;
    }
}
