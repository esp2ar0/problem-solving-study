package programmers.coding2019;

import java.util.*;

/**
 * 프로그래머스 윈터코딩 2019
 * 3번문제 지형이동
 *
 * - 겁나 오래걸린 문제
 * - 테케 몇개 통과 못함
 *
 * 1. 같은 구역으로 나눈다
 * 2. 그래프를 그린다
 * 3. 최소 신장 트리로 최소 가중치를 구한다.
 */

public class p3 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
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

    public int solution(int[][] land, int height) {
        int[][] division = new int[land.length][land.length];

        //같은 구간 구하기
        int level = 0;
        boolean[][] visited = new boolean[land.length][land.length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (!visited[i][j]) {
                    search(land, division, ++level, height, new Point(i, j), visited);
                }
            }
        }

        if(level == 1) {
            return 0;
        }

        //그래프
        int[][] a = new int[level][level];
        for (int[] ints : a) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        //그래프 값 세팅
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                setGraph(land, division, a, new Point(i, j));
            }
        }
        return mstByPrim(a);
    }

    private boolean isValid(int x, int y, int length) {
        return x >= 0 && y >= 0 && x < length && y < length;
    }

    private void search(int[][] land, int[][] division, int level, int height, Point point, boolean[][] visited) {
        int length = land.length;
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

                if (isValid(x, y, length)
                        && !visited[x][y]
                        && Math.abs(land[x][y] - currentLand) <= height) {
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private void setGraph(int[][] land, int[][] division, int[][] a, Point point) {
        int currentDivision = division[point.x][point.y];
        int currentLand = land[point.x][point.y];

        for (int i = 0; i < 4; i++) {
            int x = point.x + dx[i];
            int y = point.y + dy[i];

            if (isValid(x, y, land.length) && currentDivision != division[x][y]) {
                int value = Math.abs(currentLand - land[x][y]);
                x = division[x][y] - 1;
                y = currentDivision - 1;

                if (a[x][y] > value) {
                    a[x][y] = value;
                    a[y][x] = value;
                }
            }
        }
    }

    private static int mstByPrim(int[][] a) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<Integer> vertexSet = new HashSet<>();
        int vertex = 0;
        vertexSet.add(vertex);
        int weight = 0;
        int v = a.length;

        while (vertexSet.size() != v) {
            for (int i = 0; i < a.length; i++) {
                if (a[vertex][i] < 10000) {
                    priorityQueue.add(new Edge(i, a[vertex][i]));
                }
            }

            while (!priorityQueue.isEmpty()) {
                Edge edge = priorityQueue.poll();
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
