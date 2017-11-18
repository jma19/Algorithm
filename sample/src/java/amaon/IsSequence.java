package amaon;

/**
 * Created by junm5 on 6/21/17.
 */
public class IsSequence {

    public boolean isSubsequence(String s, String t) {
        //s = "abc", t = "ahbgdc"
        if(t.length() < s.length()){
            return false;
        }
        int indexs = 0;
        for(int i = 0; i < t.length(); i++){
            if(indexs >= s.length() -1){
                return true;
            }
            if(t.charAt(i) == s.charAt(indexs)){
                indexs++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        IsSequence isSequence = new IsSequence();
        boolean subsequence = isSequence.isSubsequence("", "");
        System.out.println(subsequence);
    }
}
