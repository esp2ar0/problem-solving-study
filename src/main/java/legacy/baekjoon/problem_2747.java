package legacy.baekjoon;

import java.util.Scanner;

public class problem_2747 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        long f1 = 0;
        long f2 = 1;
        int k = 0;

        for (int i = 0; i < n - 1; i++) {
            if(k == 0) {
                f1 = f1 + f2;
                k = 1;
            } else {
                f2 = f1 + f2;
                k = 0;
            }
        }

        if(k == 0) System.out.println(f2);
        else System.out.println(f1);
    }
}