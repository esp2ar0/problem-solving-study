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

    public int solution(int[][] land, int height) {
        int[][] division = new int[land.length][land.length];

        //같은 구간 구하기
        int level = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (division[i][j] == 0) {
                    search(land, division, ++level, height, new Point(i, j));
                }
            }
        }

        //그래프
        int[][] a = new int[level + 1][level + 1];
        for (int[] ints : a) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        //그래프 값 세팅
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                setGraph(land, division, a, new Point(i, j));
            }
        }

        return getWeightByKruskal(a);
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void search(int[][] land, int[][] division, int level, int height, Point point) {
        int length = land.length;
        boolean[][] visited = new boolean[length][length];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            point = queue.poll();
            int element = land[point.x][point.y];
            division[point.x][point.y] = level;

            if (point.x + 1 < length
                    && division[point.x + 1][point.y] == 0
                    && !visited[point.x + 1][point.y]
                    && Math.abs(land[point.x + 1][point.y] - element) <= height) {
                queue.offer(new Point(point.x + 1, point.y));
                visited[point.x + 1][point.y] = true;
            }

            if (point.x - 1 >= 0
                    && division[point.x - 1][point.y] == 0
                    && !visited[point.x - 1][point.y]
                    && Math.abs(land[point.x - 1][point.y] - element) <= height) {
                queue.offer(new Point(point.x - 1, point.y));
                visited[point.x - 1][point.y] = true;
            }

            if (point.y + 1 < length
                    && division[point.x][point.y + 1] == 0
                    && !visited[point.x][point.y + 1]
                    && Math.abs(land[point.x][point.y + 1] - element) <= height) {
                queue.offer(new Point(point.x, point.y + 1));
                visited[point.x][point.y + 1] = true;
            }

            if (point.y - 1 >= 0
                    && division[point.x][point.y - 1] == 0
                    && !visited[point.x][point.y - 1]
                    && Math.abs(land[point.x][point.y - 1] - element) <= height) {
                queue.offer(new Point(point.x, point.y - 1));
                visited[point.x][point.y - 1] = true;
            }
        }

    }

    private void setGraph(int[][] land, int[][] division, int[][] a, Point point) {
        //오른쪽
        if (point.x + 1 < land.length && division[point.x][point.y] != division[point.x + 1][point.y]) {
            int x = division[point.x][point.y];
            int y = division[point.x + 1][point.y];
            int value = Math.abs(land[point.x][point.y] - land[point.x + 1][point.y]);

            if (a[x][y] > value) {
                a[x][y] = value;
                a[y][x] = value;
            }
        }

        //아래
        if (point.y + 1 < land.length && division[point.x][point.y] != division[point.x][point.y + 1]) {
            int x = division[point.x][point.y];
            int y = division[point.x][point.y + 1];
            int value = Math.abs(land[point.x][point.y] - land[point.x][point.y + 1]);

            if (a[x][y] > value) {
                a[x][y] = value;
                a[y][x] = value;
            }
        }
    }

    class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private int getWeightByKruskal(int[][] a) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if(a[i][j] < 10000) {
                    priorityQueue.add(new Edge(i - 1, j - 1, a[i][j]));
                }
            }
        }
        int v = a.length - 1;
        int sum = 0;

        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        while(!priorityQueue.isEmpty()) {
            Edge element = priorityQueue.poll();

            int p = find(element.u, parent);
            int q = find(element.v, parent);
            if(p == q) {
                continue;
            }

            union(p, q, parent);
            sum += element.weight;
        }
        return sum;
    }

    private int find(int vertex, int[] parent) {
        int root = parent[vertex];
        if(root == vertex) {
            return root;
        }
        root = find(root, parent);
        parent[vertex] = root;
        return root;
    }

    private void union(int p, int q, int[] parent) {
        int x = find(p, parent);
        int y = find(q, parent);
        parent[x] = y;
    }


    public static void main(String[] args) {
//        int answer = new p3().solution(new int[][]{
//                {1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
//        }, 3);

        int answer = new p3().solution(new int[][]{
                {10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}
        }, 1);

        System.out.println(answer);
    }
}
