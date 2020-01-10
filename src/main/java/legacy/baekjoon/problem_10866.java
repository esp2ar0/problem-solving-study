package legacy.baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class problem_10866 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] order = scanner.nextLine().split(" ");
            if(order.length == 2) {
                if(order[0].equals("push_front")) {
                    deque.offerFirst(Integer.parseInt(order[1]));
                } else if(order[0].equals("push_back")) {
                    deque.offerLast(Integer.parseInt(order[1]));
                }
                continue;
            }
            switch (order[0]) {
                case "pop_front":
                    if (deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    if (deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekFirst());
                    break;
                case "back":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekLast());
                    break;
            }
        }
    }
}
