package bitmatulation;

import java.util.stream.Stream;

/**
 * Created by junm5 on 7/2/17.
 */
public class NumberComplement {
    public static void main(String[] args) {
        int a = 5;// 101 << 1 -1
        System.out.println(Integer.highestOneBit(a));
        String[] msg = {"AB", "vbn", "lmn"};

        Stream.of(msg).filter(s -> s.toLowerCase().matches("")).toArray(String[]::new);
    }
}
