package baekjoon;

import java.io.*;

public class problem_1332_ing {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = br.read() - '0';    br.read();
            int V = br.read() - '0';    br.readLine();
            String[] elements = br.readLine().split(" ");
            int[] P = new int[N];

            for (int i = 0; i < elements.length; i++) {
                P[i] = Integer.parseInt(elements[i]);
            } // input end



            System.out.println();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
