class Solution {
    public int ceilPos(int num, int[] arr) {
        int ans = 0;
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] >= num) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = l.length;

        int[] diff = new int[n];
        diff[0] = r[0] - l[0] + 1;

        for(int i = 1; i < n; i++) {
            diff[i] = diff[i - 1] + r[i] - l[i] + 1;
        }

        for(int i = 0; i < rank.length; i++) {
            int index = ceilPos(rank[i], diff);

            if(index == 0)
                ans.add(l[index] + rank[i] - 1);
            else
                ans.add(l[index] + rank[i] - diff[index - 1] - 1);
        }

        return ans;
    }
}
