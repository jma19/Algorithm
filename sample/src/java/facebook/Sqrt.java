package facebook;

/**
 * Created by junm5 on 1/9/17.
 */
public class Sqrt {
    public int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        long start = 1, end = x/2;
        while(start <= end){
            long middle = start + (end - start)/2;
            long res = middle * middle ;
            long nexRes = (middle + 1) * (middle + 1);
            if(res <=  x &&  nexRes > x){
                return (int)middle;
            }else if(res > x){
                end = middle - 1;
            }else {
                start = middle + 1;
            }
            //local method
        }
        return 0;
    }
    public static void main(String[] args){
        Sqrt sqrt = new Sqrt();
        int i = sqrt.mySqrt(2147395599);
        System.out.println(i);
    }
}
