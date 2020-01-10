package baekjoon.jbnu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17244 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[][] a = new int[M][N];
            String line;
            int[][] x = new int[5][2];
            int xCount = 0;
            int[] s = new int[2];
            int[] e = new int[2];
            for (int i = 0; i < M; i++) {
                line = bufferedReader.readLine();
                for (int j = 0; j < N; j++) {
                    switch (line.charAt(j)) {
                        case '#' :
                            a[i][j] = 1;
                            break;
                        case '.' :
                            a[i][j] = 0;
                            break;
                        case 'X' :
                            a[i][j] = 0;
                            x[xCount][0] = i;
                            x[xCount][1] = j;
                            xCount++;
                            break;
                        case 'S' :
                            a[i][j] = 0;
                            s[0] = i;
                            s[1] = j;
                            break;
                        case 'E' :
                            a[i][j] = 0;
                            e[0] = i;
                            e[1] = j;
                    }
                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
