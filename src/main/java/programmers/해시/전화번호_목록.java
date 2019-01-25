package programmers.해시;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) continue;
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}
