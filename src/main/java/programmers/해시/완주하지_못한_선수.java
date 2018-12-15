package programmers.해시;

import java.util.Arrays;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean find = false;

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for (String s : completion) {
            if(participant[i].equals(s)) i++;
            else {
                answer = participant[i];
                find = true;
            }
        }
        if(!find) answer = participant[i];

        return answer;
    }
}
