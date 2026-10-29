class Solution {
    public int minComputation(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : files) {
            pq.offer(x);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            int sum = x + y;
            cost += sum;

            pq.offer(sum);
        }

        return cost;
    }
}
