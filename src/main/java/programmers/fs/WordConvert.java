package programmers.fs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordConvert {
    private List<Integer> answers = new ArrayList<>();

    public int solution(String begin, String target, String[] words) {
        if (!Arrays.stream(words)
                .anyMatch(word -> word.equals(target))) {
            return 0;
        }

        boolean[] used = new boolean[words.length];
        dfs(begin, target, words, used, 0);

        if(answers.isEmpty()) {
            return 0;
        }
        Collections.sort(answers);
        return answers.get(0);
    }

    private void dfs(String begin, String target, String[] words, boolean[] used, int count) {
        if(begin.equals(target)) {
            answers.add(count);
            return;
        }
        if(count == words.length) {
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i] && isPossible(begin, words[i])) {
                used[i] = true;
                dfs(words[i], target, words, used, count + 1);
                used[i] = false;
            }
        }
    }

    private boolean isPossible(String a, String b) {
        int difference = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                difference++;
            }
        }

        return difference == 1;
    }
}
