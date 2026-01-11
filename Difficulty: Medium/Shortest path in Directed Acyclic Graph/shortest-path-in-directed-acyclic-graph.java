import java.util.*;

class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {

        int dist[] = new int[V + 1];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] node = queue.poll();   // FIXED
            int value = node[0];
            int dis = node[1];

            for (int[] it : edges) {     // FIXED
                if (it[0] == value && dist[it[1]] > dis + it[2]) {
                    dist[it[1]] = dis + it[2];
                    queue.offer(new int[]{it[1], dist[it[1]]});
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
