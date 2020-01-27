package programmers.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * 기능개발
 *
 */

public class p1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> answerList = new LinkedList<>();
        int[] days = new int[progresses.length];

        int day = 0;
        for (int i = 0; i < progresses.length; i++) {
            int value = progresses[i];
            while(value < 100) {
                value += speeds[i];
                day++;
            }
            days[i] = day;
            day = 0;
        }

        int temp = days[0];
        int count = 1;
        for (int i = 1; i < days.length; i++) {
            if(days[i] <= temp) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                temp = days[i];
            }
        }
        answerList.add(count);

        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = new p1().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});

        for (int i : answer) {
            System.out.println(i + " ");
        }
    }
}
