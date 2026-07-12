import java.util.*;

class Solution {
    public int maxAmount(int[] arr, int k) {
        long MOD = 1000000007;
        long ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int tickets : arr) {
            pq.offer(tickets);
        }

        while (k > 0 && !pq.isEmpty()) {
            int maxTickets = pq.poll();

            ans = (ans + maxTickets) % MOD;

            if (maxTickets > 1) {
                pq.offer(maxTickets - 1);
            }

            k--;
        }

        return (int) ans;
    }
}
