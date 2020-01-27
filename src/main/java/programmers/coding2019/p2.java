package programmers.coding2019;

/**
 * 서머코딩 윈터코딩 2019
 * 2번 문제 종이접기
 *
 * 1. 종이를 한 번 더 접을 때마다 기존 원소들의 앞뒤로 0, 1이 번갈아가며 추가된다
 * 2. 처음엔 LinkedList로 했으나 시간초과가 나서 배열로 처리.
 */

public class p2 {

    public int[] solution(int n) {
        int[] a = new int[]{0};
        int[] b = new int[0];
        if(n == 1) {
            return a;
        }

        int increment = 2;
        for (int i = 2; i <= n; i++) {
            if(a.length > b.length) {
                b = getNextArray(a, increment);
            } else {
                a = getNextArray(b, increment);
            }
            increment *= 2;
        }

        return a.length > b.length ? a : b;
    }

    private int[] getNextArray(int[] array, int increment) {
        int[] nextArray = new int[array.length + increment];
        int element = 0;
        int index = 0;

        for (int i = 0; i < nextArray.length; i++) {
            if (i % 2 == 0) {
                nextArray[i] = element;
                element = element == 0 ? 1 : 0;
            } else {
                nextArray[i] = array[index++];
            }
        }
        return nextArray;
    }

    /*
    시간초과가 난 코드. 위 코드와 시간 차이가 많이난다.

        public int[] solution(int n) {
            List<Integer> answerList = new LinkedList<>();
            int multiple = 1;
            int index = 0;
            int element = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < multiple; j++) {
                    answerList.add(index, element);
                    element = element == 0 ? 1 : 0;
                    index += 2;
                }
                multiple *= 2;
                index = 0;
                element = 0;
            }

            int[] answer = new int[answerList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    */

    public static void main(String[] args) {
        int[] answer = new p2().solution(4);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
