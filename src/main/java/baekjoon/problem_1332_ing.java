package baekjoon;

import java.io.*;

public class problem_1332_ing {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = br.read() - '0';
            br.read();
            int V = br.read() - '0';
            br.readLine();
            String[] element = br.readLine().split(" ");
            int[] P = new int[element.length];
            for (int i = 0; i < element.length; i++) {
                P[i] = Integer.parseInt(element[i]);
            } // input end




            int max_interest = Integer.MIN_VALUE;
            int min_interest = Integer.MAX_VALUE;

            int count = 0;
            int diff = max_interest - min_interest;
            int temp;
            for (int i = 0; i < N; i++) {
                if(diff >= V) break;

                max_interest = max_interest < P[i] ? P[i] : max_interest;
                min_interest = min_interest < P[i] ? min_interest : P[i];
                diff = max_interest - min_interest;

                count++;
            }




            System.out.println();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static int calculateDiff(int max_interest, int min_interest, int P) {
        max_interest = max_interest < P ? P : max_interest;
        min_interest = min_interest < P ? min_interest : P;
        return  max_interest - min_interest;
    }
}
