package com.uci.mj;

/**
 * Created by junm5 on 12/21/16.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {

        int diffConstant = 2*numRows - 2, i, index;
        StringBuffer res = new StringBuffer();
        for(i = 0; i < numRows; i++){
            index = i;
            boolean isEven = true;
            while(index < s.length()){
                res.append(s.charAt(index));
                if(i == 0 || i == numRows -1){
                    index += diffConstant;
                }else{
                    if(isEven){
                        index += 2*(numRows-i) - 2;
                    }else{
                        index +=  2*i;
                    }
                    isEven = !isEven;
                }
            }
            int a = 123321;
            //3223

        }
        return res.toString();
    }
    public static void main(String [] args){
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String paypalishiring = zigZagConversion.convert("ABCDE", 4);
        System.out.println(paypalishiring);
    }
}
