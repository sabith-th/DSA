package DSA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class ShortestPathInDAG {
    class Pair {
        int v;
        int w;
        Pair(int v, int w) {
            this.w = w;
            this.v = v;
        }
    }

    private void topologicalSort(int node, ArrayList<ArrayList<Pair>> adjList, boolean[] visited, ArrayDeque<Integer> tSort) {
        visited[node] = true;
        for (Pair neighbor : adjList.get(node)) {
            if (!visited[neighbor.v]) {
                topologicalSort(neighbor.v, adjList, visited, tSort);
            }
        }
        tSort.add(node);
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        //Code here
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];

        ArrayDeque<Integer> tSort = new ArrayDeque<>();
        topologicalSort(0, adjList, visited, tSort);
        dist[0] = 0;
        while (!tSort.isEmpty()) {
            int node = tSort.removeLast();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adjList.get(node)) {
                    if (dist[node] + neighbor.w < dist[neighbor.v]) {
                        dist[neighbor.v] = dist[node] + neighbor.w;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
