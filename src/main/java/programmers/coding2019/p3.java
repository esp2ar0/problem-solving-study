package programmers.coding2019;

import java.util.*;

/**
 * 프로그래머스 윈터코딩 2019
 * 3번문제 지형이동
 *
 * - 겁나 오래걸린 문제
 *
 * 1. 같은 구역으로 나눈다
 * 2. 그래프를 그린다
 *      -> 그래프를 인접행렬로 표현시 메모리 초과
 *      -> 인접리스트로 표현, 모든 간선 추가 후 가장 저렴한 간선만 사용
 * 3. 최소 신장 트리로 최소 가중치를 구한다.
 */

public class p3 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land, int height) {
        // 같은 구간 구하기
        int level = 0;
        int[][] division = new int[land.length][land.length];
        boolean[][] visited = new boolean[land.length][land.length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (!visited[i][j]) {
                    search(land, division, ++level, height, new Point(i, j), visited);
                }
            }
        }

        // 그래프 생성
        List<List<Edge>> a = new ArrayList<>(level);
        for (int i = 0; i < level; i++) {
            a.add(new ArrayList<>());
        }
        // 그래프 세팅
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                setGraph(land, division, a, new Point(i, j));
            }
        }
        // 한 정점에 대해 1)target 2)weight 오름차순 정렬
        for (int i = 0; i < level; i++) {
            Collections.sort(a.get(i));
        }
        return mstByPrim(a);
    }

    private boolean isValid(int x, int y, int length) {
        return x >= 0 && y >= 0 && x < length && y < length;
    }

    private void search(int[][] land, int[][] division, int level, int height, Point point, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            point = queue.poll();
            int currentLand = land[point.x][point.y];
            division[point.x][point.y] = level;

            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];

                if (isValid(x, y, land.length)
                        && !visited[x][y]
                        && Math.abs(land[x][y] - currentLand) <= height) {
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private void setGraph(int[][] land, int[][] division, List<List<Edge>> a, Point point) {
        int currentDivision = division[point.x][point.y];
        int currentLand = land[point.x][point.y];

        for (int i = 0; i < 4; i++) {
            int x = point.x + dx[i];
            int y = point.y + dy[i];

            if (isValid(x, y, land.length) && currentDivision != division[x][y]) {
                int value = Math.abs(currentLand - land[x][y]);
                x = division[x][y] - 1;
                y = currentDivision - 1;

                a.get(x).add(new Edge(y, value));
                a.get(y).add(new Edge(x, value));
            }
        }
    }

    private static int mstByPrim(List<List<Edge>> a) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<Integer> vertexSet = new HashSet<>();
        int vertex = 0;
        vertexSet.add(vertex);
        int weight = 0;
        int v = a.size();

        while (vertexSet.size() != v) {
            List<Edge> edgeList = a.get(vertex);
            Edge edge = edgeList.get(0);
            priorityQueue.add(edge);
            for (int i = 1; i < edgeList.size(); i++) {
                if(edgeList.get(i).target == edge.target) {
                    continue;
                }
                edge = edgeList.get(i);
                priorityQueue.add(edge);
            }

            while (!priorityQueue.isEmpty()) {
                edge = priorityQueue.poll();
                if (!vertexSet.contains(edge.target)) {
                    vertex = edge.target;
                    weight += edge.weight;
                    vertexSet.add(vertex);
                    break;
                }
            }
        }
        return weight;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge>{
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.target == o.target) {
                return Integer.compare(this.weight, o.weight);
            }
            return Integer.compare(this.target, o.target);
        }
    }

    public static void main(String[] args) {
//        int answer = new p3().solution(new int[][]{
//                {1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
//        }, 3);

//        int answer = new p3().solution(new int[][]{
//                {10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}
//        }, 1);
        int answer = new p3().solution(new int[][]{
                {1, 3, 5, 7}, {15, 13, 11, 9}, {17, 19, 21, 23}, {31, 29, 27, 25}
        }, 2);

        System.out.println(answer);
    }
}