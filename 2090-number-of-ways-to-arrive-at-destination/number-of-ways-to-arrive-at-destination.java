class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        // adjacency list: {nextNode, time}
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0}); // {time, node}

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) continue;

            for (int[] it : graph.get(node)) {
                int next = it[0];
                long newTime = time + it[1];

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    ways[next] = ways[node];
                    pq.add(new long[]{newTime, next});
                }
                else if (newTime == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
