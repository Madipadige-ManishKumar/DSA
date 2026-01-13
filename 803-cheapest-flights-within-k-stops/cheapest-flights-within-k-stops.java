import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(
                new int[]{flights[i][1], flights[i][2]}
            );
        }

        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, src, 0});
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];
            int stops = cur[2];

            if (node == dst) {
                return cost;
            }

            if (stops > k) continue;

            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int price = edge[1];

                int newCost = cost + price;

                if (newCost < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newCost;
                    pq.add(new int[]{newCost, next, stops + 1});
                }
            }
        }

        return -1;
    }
}
