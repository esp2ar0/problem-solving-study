package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1759 {
    private static Set<String> set = new TreeSet<>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int L = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());
            char[] alphabet = new char[C];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < C; i++) {
                alphabet[i] = stringTokenizer.nextToken().charAt(0);
            }

            solve(alphabet, L, new LinkedList<>(), new boolean[C]);
            for (String s : set) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(char[] alphabet, int L, List<Character> list, boolean[] check) {
        if(list.size() == L) {
            if (isValid(list)) {
                set.add(convert(list));
            }
            return;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (!check[i] && isPossible(list, alphabet[i])) {
                list.add(alphabet[i]);
                check[i] = true;
                solve(alphabet, L, list, check);
                list.remove((Character)alphabet[i]);
                check[i] = false;
            }
        }
    }

    private static boolean isPossible(List<Character> list, char next) {
        if(list.isEmpty()) {
            return true;
        }
        for (char c : list) {
            if(c > next) {
                return false;
            }
        }
        return true;
    }

    private static String convert(List<Character> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private static boolean isValid(List<Character> list) {
        int consonantCount = 0;
        int vowelCount = 0;

        for (char c : list) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return consonantCount >= 2 && vowelCount >= 1;
    }
}
