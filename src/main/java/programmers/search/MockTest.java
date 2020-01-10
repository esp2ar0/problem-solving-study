package programmers.search;

import java.util.*;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] answer = {};

        List<Integer> answerCount = new ArrayList<>();

        Queue<Integer> a = new LinkedList<>();
        a.offer(1);
        a.offer(2);
        a.offer(3);
        a.offer(4);
        a.offer(5);
        answerCount.add(solve(a, answers));

        Queue<Integer> b = new LinkedList<>();
        b.offer(2);
        b.offer(1);
        b.offer(2);
        b.offer(3);
        b.offer(2);
        b.offer(4);
        b.offer(2);
        b.offer(5);
        answerCount.add(solve(b, answers));

        Queue<Integer> c = new LinkedList<>();
        c.offer(3);
        c.offer(3);
        c.offer(1);
        c.offer(1);
        c.offer(2);
        c.offer(2);
        c.offer(4);
        c.offer(4);
        c.offer(5);
        c.offer(5);
        answerCount.add(solve(c, answers));


        int max = Collections.max(answerCount);

        int maxCount = 0;
        for (Integer integer : answerCount) {
            if (max == integer) {
                maxCount++;
            }
        }

        answer = new int[maxCount];

        int j = 0;
        for (int i = 0; i < answerCount.size(); i++) {
            if(answerCount.get(i) == max) {
                answer[j] = i + 1;
                j++;
            }
        }

        return answer;
    }

    private int solve(Queue<Integer> queue, int[] answers) {
        int count = 0;
        int number;
        for (int i = 0; i < answers.length; i++) {
            number = queue.poll();
            queue.offer(number);

            if (number == answers[i]) {
                count++;
            }
        }
        return count;
    }

}
