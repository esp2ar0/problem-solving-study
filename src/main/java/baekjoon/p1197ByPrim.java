package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1197ByPrim {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splitLine = bufferedReader.readLine().split(" ");
            int V = Integer.parseInt(splitLine[0]);
            int E = Integer.parseInt(splitLine[1]);

            List<List<Edge>> a = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                a.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                splitLine = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(splitLine[0]);
                int v = Integer.parseInt(splitLine[1]);
                int weight = Integer.parseInt(splitLine[2]);

                a.get(u - 1).add(new Edge(v - 1, weight));
                a.get(v - 1).add(new Edge(u - 1, weight));
            }
            System.out.println(getWeightByPrim(a));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    private static int getWeightByPrim(List<List<Edge>> a) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<Integer> vertexSet = new HashSet<>();
        int vertex = 0;
        vertexSet.add(vertex);
        int weight = 0;
        int v = a.size();

        while(vertexSet.size() != v) {
            priorityQueue.addAll(a.get(vertex));

            while(!priorityQueue.isEmpty()) {
                Edge edge = priorityQueue.poll();
                if(!vertexSet.contains(edge.target)) {
                    vertex = edge.target;
                    weight += edge.weight;
                    vertexSet.add(vertex);
                    break;
                }
            }
        }
        return weight;
    }
}
