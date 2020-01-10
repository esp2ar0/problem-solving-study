package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/9375
 * 패션왕 신해빈
 * 단계별 수학3
 */
public class p9375 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(bufferedReader.readLine());
                int answer = 1;
                for (int j = 0; j < n; j++) {
                    String[] line = bufferedReader.readLine().split(" ");
                    if(map.containsKey(line[1])) {
                        map.put(line[1], map.get(line[1]) + 1);
                    } else {
                        map.put(line[1], 1);
                    }
                }
                for (String s : map.keySet()) {
                    answer *= (map.get(s) + 1);
                }
                answer--;
                System.out.println(answer);
                map.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
