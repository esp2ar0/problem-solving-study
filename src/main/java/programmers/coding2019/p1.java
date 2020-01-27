package programmers.coding2019;

import java.math.BigInteger;

/**
 * 서머코딩 윈터코딩 2019
 * 1번문제 멀쩡한 사각형
 *
 * 1. 1억 * 1억의 범위 초과에 대비해 BigInteger 사용
 * 2. 규칙 찾기
 *      - 가로와 세로를 최대 공약수로 나눈 작은 사각형의 반복
 *      - 그 작은 사각형에서만 대각선이 지남
 *      - 작은w + 작은h - 1만큼 지남
 *      - gcd 만큼 반복
 */

public class p1 {

    public long solution(int w, int h) {
        int gcd = gcd(w, h);

        return BigInteger.valueOf(w)
                .multiply(BigInteger.valueOf(h))
                .subtract(BigInteger.valueOf(w / gcd + h / gcd - 1)
                            .multiply(BigInteger.valueOf(gcd)))
                .longValue();
    }

    private int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
