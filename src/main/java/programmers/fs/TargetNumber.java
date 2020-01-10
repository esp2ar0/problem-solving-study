package programmers.fs;

public class TargetNumber {
    private static int count = 0;

    private static void dfs(int[] numbers, int i, int sum, int target) {
        if(i >= numbers.length) {
            return;
        }
        int left = sum + numbers[i];
        int right = sum - numbers[i];

        if(i == numbers.length - 1 && (left == target || right == target)) {
            count++;
            return;
        }

        i++;
        dfs(numbers, i, left, target);
        dfs(numbers, i, right, target);
    }

    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);

        return count;
    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        System.out.println(targetNumber.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
