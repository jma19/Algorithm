package Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junm5 on 1/26/17.
 */
public class IMask {

    private static String emailMask(String email) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            bufferedReader.close();
        }
        return line;
    }

    private static int numberOfCountryCode(char ch[]) {
        int num = 0;
        for (char c : ch) {
            if (Character.isDigit(c)) {
                num++;
            }
        }
        return num - 10;
    }


    private static String phoneMask(String phone) throws Exception{
        StringBuilder sb = new StringBuilder("P:");
        char[] arr = phone.toCharArray();
        boolean extra = false;
        int numberOfCountryCode = numberOfCountryCode(arr);
        if (numberOfCountryCode > 0) {
            sb.append('+');
            extra = true;
            String str = "";
            if(str.matches("^\\w+@\\w+\\.(com|cn)")){

            }
        }
        int cur = 0;
        while (cur < arr.length && numberOfCountryCode > 0) {
            if (Character.isDigit(arr[cur])) {
                sb.append('*');
                numberOfCountryCode--;
            }
            cur++;
        }
        if (extra) {
            sb.append('-');
        }
        sb.append("***-***-");
        int cnt = 6;
        while (cur < arr.length && cnt > 0) {
            if (Character.isDigit(arr[cur])) {
                cnt--;
            }
            cur++;
        }
        cnt = 4;
        while (cur < arr.length && cnt > 0) {
            if (Character.isDigit(arr[cur])) {
                sb.append(arr[cur]);
                cnt--;
            }
            cur++;
        }
        return sb.toString();
    }


    public static void main(String args[]) throws Exception {
        System.out.println(phoneMask("(333) 456-7890"));
        System.out.println("asncksn@twitter.com".matches("^\\w+@\\w+\\.(com|cn)"));
    }

}
