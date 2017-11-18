package Twitter;

/**
 * Created by junm5 on 6/26/17.
 */
public class Permutation {
    void permutaton(String str) {
        permutaton(str, "");
    }

    private void permutaton(String str, String s) {
        if (str.length() == 0) {
            System.out.println(s);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutaton(rem, s + str.charAt(i));

            }
        }
    }
    public static void main(String[]ars){
        Permutation permutation = new Permutation();
        permutation.permutaton("abc");
    }
}
