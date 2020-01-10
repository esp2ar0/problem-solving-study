package baekjoon.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 바이러스
 * 비방향그래프인데 한쪽 방향만 추가해줘서 틀렸다.
 */
public class p2606 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int computer = Integer.parseInt(bufferedReader.readLine());
            int connect = Integer.parseInt(bufferedReader.readLine());

            List<List<Integer>> a = new LinkedList<>();
            for (int i = 0; i < computer; i++) {
                a.add(new LinkedList<>());
            }

            for (int i = 0; i < connect; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int c1 = Integer.parseInt(stringTokenizer.nextToken());
                int c2 = Integer.parseInt(stringTokenizer.nextToken());
                a.get(c1-1).add(c2-1);
                a.get(c2-1).add(c1-1);
            }

            solve(a, new boolean[computer]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(List<List<Integer>> a, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int v = queue.poll();

            for (Integer i : a.get(v)) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
