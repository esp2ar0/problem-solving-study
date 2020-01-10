package baekjoon.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 * 단계별 - 1번
 */
public class p1260 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splitLine = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(splitLine[0]);
            int m = Integer.parseInt(splitLine[1]);
            int v = Integer.parseInt(splitLine[2]);

            List<List<Integer>> a = new ArrayList<>(n + 1);

            for (int i = 0; i <= n; i++) {
                a.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                splitLine = bufferedReader.readLine().split(" ");
                a.get(Integer.parseInt(splitLine[0])).add(Integer.parseInt(splitLine[1]));
                a.get(Integer.parseInt(splitLine[1])).add(Integer.parseInt(splitLine[0]));
            }

            for (int i = 1; i <= n; i++) {
                Collections.sort(a.get(i));
            }

            dfs(a, new boolean[n + 1], v);
            System.out.println();
            bfs(a, new boolean[n + 1], v);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs_stack(List<List<Integer>> a, boolean[] visited, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;

        stack.push(v);
        visited[v] = true;
        System.out.print(v + " ");


        while (!stack.empty()) {
            int vv = stack.peek();
            flag = false;

            for (Integer i : a.get(vv)) {
                if(!visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                    flag = true;
                    break;
                }

            }

            if(!flag) {
                stack.pop();
            }
        }
    }

    private static void dfs(List<List<Integer>> a, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer i : a.get(v)) {
            if(!visited[i]) {
                dfs(a, visited, i);
            }
        }
    }

    private static void bfs(List<List<Integer>> a, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (Integer i : a.get(v)) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
