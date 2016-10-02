package com.uci.mj;


/**
 * Created by junm5 on 9/29/16.
 */
public class QueueTest {
    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest();
        int i = queueTest.strStr("mississippi", "issip");
        System.out.println(i);

    }
    public int strStr(String haystack, String needle) {
        if("".equals(haystack) && "".equals(needle)){
            return 0;
        }
        int i = 0;
        while(i < haystack.length()){
            int q = i;
            int k = 0;
            while(k < needle.length() && q < haystack.length() && needle.charAt(k) == haystack.charAt(q)){
                k++;
                q++;
            }
            if(k == needle.length()){
                return i;
            }
            i++;
        }
        return -1;
    }
    //
    private Long getUnsignedValue(int num){
        return num & 0x00000000ffffffffl;
    }
    char[] ch = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        String res = "";

        long temp = getUnsignedValue(num);

        while(temp > 0){
            long tempRes = temp % 16;
            res += ch[(int)tempRes];
            temp = temp/16;
        }
        return res;
    }
}
