package amaon;

/**
 * Created by junm5 on 2/5/17.
 */
public class Replace {
    public  String replace(String str, String xxx) {
        //cnt the number of " "
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                cnt++;
            }
        }
        int totoalLen = str.length() - cnt + xxx.length() * cnt;
        char res[] = new char[totoalLen];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                for (int j = 0; j < xxx.length(); j++) {
                    res[index++] = xxx.charAt(j);
                }
            } else {
                res[index++] = str.charAt(i);
            }
        }
        return new String(res);
    }
    public static void main(String [] args){
        Replace replace = new Replace();
        String res = replace.replace("abc abc  abc", "xx");
        System.out.println(res);
    }
}
