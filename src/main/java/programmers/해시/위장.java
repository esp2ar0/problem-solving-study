package programmers.해시;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        for (Integer value : map.values()) {
            answer *= (value + 1);
        }
        answer--;
        return answer;
    }
}
