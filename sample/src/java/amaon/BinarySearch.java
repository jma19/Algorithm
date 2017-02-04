package amaon;


/**
 * Created by junm5 on 1/28/17.
 */
public class BinarySearch {
    public static void main(String[] args){
//        int[] heaters = {1,2,4,5,6,7,8,8};
//        int i = binarySeacrh(heaters, 9);
//        System.out.println(i);
        System.out.println(4 & (~3));
    }
    //find the nearst index for target
    private static int binarySeacrh(int[] array, int target){
        int start = 0, end = array.length - 1;
        while(start <= end){
            int middle = (start + end)/2;
            if(array[middle] >  target){
                end = middle - 1;
            }
            else{
                start = middle + 1;
            }
        }
        return start;
    }

}
