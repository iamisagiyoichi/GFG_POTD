import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int N = n * n;
        int[] jump = new int[N + 1];
        Arrays.fill(jump, -1);

        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] vis = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        vis[1] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int curr = q.poll();

                if (curr == N) {
                    return ans;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;

                    if (next > N) {
                        break;
                    }

                    if (jump[next] != -1) {
                        next = jump[next];
                    }

                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }

            ans++;
        }

        return -1;
    }
}
