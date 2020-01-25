package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/11403
 * 경로 찾기
 */
public class p11403 {
    private static int answer[][];

    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine());

            List<List<Integer>> a = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                a.add(new ArrayList<>());
            }
            answer = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] splitLine = bufferedReader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (Integer.parseInt(splitLine[j]) == 1) {
                        a.get(i).add(j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                dfs(a, new boolean[N], i, i);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(List<List<Integer>> a, boolean[] visited, int v, int start) {
        if(v != start) {
            visited[v] = true;
            answer[start][v] = 1;
        }

        for (Integer i : a.get(v)) {
            if(i == start) {
                visited[i] = true;
                answer[start][i] = 1;
            }
            if(!visited[i]) {
                dfs(a, visited, i, start);
            }
        }
    }
}
