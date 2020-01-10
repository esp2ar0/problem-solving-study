package programmers.fs;

import java.util.*;

public class TravelPath {

    public String[] solution(String[][] tickets) {
        String[] answer;

        Set<String> set = new TreeSet<>();
        for (String[] ticket : tickets) {
            for (String airport : ticket) {
                set.add(airport);
            }
        }

        List<String> list = new ArrayList<>(set);

        int[][] ticketCount = new int[list.size()][list.size()];

        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            a.add(new ArrayList<>());
        }

        int start = list.indexOf("ICN");

        for (String[] ticket : tickets) {
            int i = list.indexOf(ticket[0]);
            int j = list.indexOf(ticket[1]);
            a.get(i).add(j);
            ticketCount[i][j]++;
        }

        for (List<Integer> integers : a) {
            Collections.sort(integers);
        }

        List<Integer> answers = new LinkedList<>();
        answers.add(start);
        dfs(a, ticketCount, start, answers);

        answer = new String[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = list.get(answers.get(i));
        }

        return answer;
    }

    private boolean dfs(List<List<Integer>> a, int[][] ticketCount, int start, List<Integer> answers) {
        if (isOver(ticketCount)) {
            return true;
        }

        for (Integer i : a.get(start)) {
            if (ticketCount[start][i] == 0) {
                continue;
            }
            ticketCount[start][i]--;
            answers.add(i);
            if (dfs(a, ticketCount, i, answers)) {
                return true;
            }
            answers.remove(i);
            ticketCount[start][i]++;
        }
        return false;
    }

    private boolean isOver(int[][] isValidTicket) {
        for (int i = 0; i < isValidTicket.length; i++) {
            for (int j = 0; j < isValidTicket[0].length; j++) {
                if (isValidTicket[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
