package legacy.baekjoon.dynamic_programing_basic;

import java.io.*;

public class problem_2579 {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n];
            int[] sum = new int[n];

            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(br.readLine());
            }
            sum[0] = score[0];
            sum[1] = score[0] + score[1];
            sum[2] = Math.max(score[0], score[1]) + score[2];

            for (int i = 3; i < n; i++) {
                sum[i] = Math.max(sum[i-3] + score[i-1] + score[i], sum[i-2] + score[i]);
            }

            bw.write(Integer.toString(sum[n-1]));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
