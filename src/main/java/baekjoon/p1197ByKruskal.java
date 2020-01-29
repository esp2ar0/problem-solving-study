package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1197ByKruskal {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splitLine = bufferedReader.readLine().split(" ");
            int V = Integer.parseInt(splitLine[0]);
            int E = Integer.parseInt(splitLine[1]);

            PriorityQueue<Edge> a = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

            for (int i = 0; i < E; i++) {
                splitLine = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(splitLine[0]);
                int v = Integer.parseInt(splitLine[1]);
                int weight = Integer.parseInt(splitLine[2]);

                a.offer(new Edge(u - 1, v - 1, weight));
            }
            System.out.println(getWeightByKruskal(a, V));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private static int getWeightByKruskal(PriorityQueue<Edge> priorityQueue, int v) {
        int sum = 0;

        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        while(!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();

            int p = find(edge.u, parent);
            int q = find(edge.v, parent);
            if(p == q) {
                continue;
            }

            union(p, q, parent);
            sum += edge.weight;
        }
        return sum;
    }

    private static int find(int vertex, int[] parent) {
        int root = parent[vertex];
        if(root == vertex) {
            return root;
        }
        root = find(root, parent);
        parent[vertex] = root;
        return root;
    }

    private static void union(int p, int q, int[] parent) {
        int x = find(p, parent);
        int y = find(q, parent);
        parent[x] = y;
    }
}
