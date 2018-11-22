package baekjoon;

import java.util.*;

public class problem_11866 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        System.out.println(solveJosephus(initQueue(N), M));
    }

    public static Queue<Integer> initQueue(int N) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        return queue;
    }

    public static String solveJosephus(Queue<Integer> queue, int M) {
        int count = 0;
        int temp;
        StringBuilder sb = new StringBuilder("<");

        while(queue.size() != 1) {
            count++;
            temp = queue.poll();

            if(count == M) {
                count = 0;
                sb.append(temp);
                sb.append(", ");
            } else {
                queue.offer(temp);
            }
        }
        sb.append(queue.poll());
        sb.append(">");

        return sb.toString();
    }
}