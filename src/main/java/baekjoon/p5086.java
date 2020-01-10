package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/5086
 * 배수와 약수
 * 단계별 - 수학3 1번문제
 */
public class p5086 {

    private static String solve(int a, int b) {
        if(b % a == 0) {
            return "factor";
        }
        if(a % b == 0) {
            return "multiple";
        }
        return "neither";
    }

    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                String[] numbers = bufferedReader.readLine().split(" ");

                int a = Integer.parseInt(numbers[0]);
                int b = Integer.parseInt(numbers[1]);
                if (a == 0 && b == 0) {
                    break;
                }
                System.out.println(solve(a, b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
