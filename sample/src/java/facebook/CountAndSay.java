package facebook;

/**
 * Created by junm5 on 1/8/17.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String pre = "1";
        for(int i = 0; i < n - 1; i++){
            pre = transform(pre);
        }
        return pre;
    }
    private String transform(String str){
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char ch[] = str.toCharArray();
        char pre = ch[0];
        for(int i = 1; i < str.length(); i++){
            if(ch[i] == pre){
                count++;
            }else{
                sb.append(""+count + pre);
                pre = ch[i];
                count = 1;
            }
        }
        return sb.append(""+ count + pre).toString();
    }
    public static void main(String [] args){
        CountAndSay countAndSay = new CountAndSay();
        String transform = countAndSay.transform("1112");
        System.out.println(countAndSay.countAndSay(5));
        String a ="123";
        String s = new String(a.toCharArray());
        System.out.println(s);
    }
}
