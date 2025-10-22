import java.util.*;

class Solution {
    // DSU (Disjoint Set Union)
    static int find(int parent[], int s) {
        if (parent[s] == s)
            return s;
        return parent[s] = find(parent, parent[s]); // Path compression
    }

    static void union(int parent[], int u, int v) {
        parent[v] = u; // attach v’s root to u’s root
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;

        // Step 1: Create job list
        class Job {
            int id, deadline, profit;
            Job(int id, int deadline, int profit) {
                this.id = id;
                this.deadline = deadline;
                this.profit = profit;
            }
        }

        Job[] jobs = new Job[n];
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i + 1, deadline[i], profit[i]);
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Step 2: Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 3: Initialize DSU parent array
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) parent[i] = i;

        int countJobs = 0, totalProfit = 0;

        // Step 4: Schedule jobs optimally using DSU
        for (Job job : jobs) {
            // Find latest available slot before or on its deadline
            int available = find(parent, job.deadline);
            if (available > 0) { // if slot exists
                // Mark this slot as occupied → union it with previous
                union(parent, find(parent, available - 1), available);
                countJobs++;
                totalProfit += job.profit;
            }
        }

        // Step 5: Return result
        ArrayList<Integer> res = new ArrayList<>();
        res.add(countJobs);
        res.add(totalProfit);
        return res;
    }
}
