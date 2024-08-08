package DSA;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] indegree = new int[V];
        for (ArrayList<Integer> neighbors : adj) {
            for (int v : neighbors) {
                indegree[v]++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[V];
        boolean[] visited = new boolean[V];
        int i = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            if (!visited[v]) {
                for (int u: adj.get(v)) {
                    indegree[u]--;
                    if (indegree[u] == 0) {
                        q.offer(u);
                    }
                }
            }
            visited[v] = true;
            res[i++] = v;
        }

        return res;
    }
}
