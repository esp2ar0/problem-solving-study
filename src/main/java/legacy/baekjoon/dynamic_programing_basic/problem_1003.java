package legacy.baekjoon.dynamic_programing_basic;

import java.io.*;

public class problem_1003 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                bw.write(getCount(Integer.parseInt(br.readLine())) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCount(int N) {
        if(N == 0) return "1 0";
        if(N == 1) return "0 1";
        int count[][] = new int[N+1][2];

        count[0][0] = 1;
        count[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            count[i][0] = count[i-2][0] + count[i-1][0];
            count[i][1] = count[i-2][1] + count[i-1][1];
        }

        return Integer.toString(count[N][0]) + " " + Integer.toString(count[N][1]);
    }
}