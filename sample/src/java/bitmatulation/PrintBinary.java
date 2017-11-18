package bitmatulation;

import java.math.BigInteger;

/**
 * Created by junm5 on 7/5/17.
 */
public class PrintBinary {

    public static void printBinary(String n) {
        int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
        double doublePart = Double.parseDouble(n.substring(n.indexOf("."), n.length()));
        System.out.println(doublePart);
    }

    public static String getBinaryInteger(int intPart) {
        String int_string = "";
        while (intPart > 0) {
            int r = intPart % 2;//
            intPart >>= 1;
            int_string = r + int_string;
        }
        return int_string;
    }

    public static String getBinaryDouble(double decPart) {
        StringBuffer dec_string = new StringBuffer();
        while (decPart > 0) {
            if (dec_string.length() > 32)
                return "ERROR";
            if (decPart == 1) {
                dec_string.append((int) decPart);
                break;
            }
            double r = decPart * 2;
            if (r >= 1) {
                dec_string.append(1);
                decPart = r - 1;
            } else {
                dec_string.append(0);
                decPart = r;
            }
        }
        return dec_string.toString();
    }

    public static void main(String[] args) {
        PrintBinary.printBinary("1.111");
        System.out.println(getBinaryInteger(12));
    }
}
