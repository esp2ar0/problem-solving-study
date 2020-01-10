package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1037
 * 약수
 * 단계별 - 수학3 2번문제
 *
 * 포기.
 * 해법 : 첫번째 약수 * 마지막 약수 = 구하고자 하는 수
 * 정렬 해야함. 젤 큰 약수 * 젤 작은 약수
 */
public class p1037 {

    private static int solve(String[] divisor) {
        List<Integer> list = new ArrayList<>(divisor.length);

        for (int i = 0; i < divisor.length; i++) {
            list.add(Integer.parseInt(divisor[i]));
        }

        Collections.sort(list);

        return list.get(0) * list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(bufferedReader.readLine());
            String[] divisor = bufferedReader.readLine().split(" ");

            System.out.println(solve(divisor));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
