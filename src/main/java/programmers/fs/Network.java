package programmers.fs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                answer++;
            }
            while (!queue.isEmpty()) {
                int vv = queue.poll();

                for (int j = 0; j < n; j++) {
                    if (!visited[j] && computers[vv][j] == 1) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }

        return answer;
    }

}
