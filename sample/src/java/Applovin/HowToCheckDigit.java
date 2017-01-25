package Applovin;

/**
 * Created by junm5 on 1/14/17.
 */
public class HowToCheckDigit {

    private boolean containsAllDigits(String str) {
        String reg = "[0-9]+";
        return str.matches(reg);
    }

}
