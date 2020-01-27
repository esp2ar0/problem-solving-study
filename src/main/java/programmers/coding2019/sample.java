package programmers.coding2019;

import java.util.LinkedList;
import java.util.List;

public class sample {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        int j = 0;
        for (int i = 0; i < 8; i++) {
            list.add(j, 0);
            j+=2;
        }



        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
