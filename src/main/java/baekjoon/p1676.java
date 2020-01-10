package baekjoon;

import java.util.Scanner;

public class p1676 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int number = 1;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            number *= i;
            while (number % 10 == 0) {
                number /= 10;
                count++;
            }
        }
        System.out.println(count);
    }
}
