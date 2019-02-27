import java.io.*;

/*
Given two strings write a method to decide if one is a permutation of the other.
 */

public class isPermutation {

    private boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for(char c : s_array){
            letters[c]++;
        }

        for(int i = 0; i < t.length(); i++){
            int c = (int) t.charAt(i);
            letters[c]--;
            if(letters[c] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPermutation perm = new isPermutation();

        String strA = "dog";
        String strB = "god";

        String strC = "poopie pants";
        String strD = "oopiep stnap";

        String strE = "notequal";
        String strF = "biteme";

        System.out.println("String A: " + strA + " - String B: " + strB + " - are equal? : " + perm.permutation(strA, strB));
        System.out.println("String C: " + strC + " - String D: " + strD + " - are equal? : " + perm.permutation(strC, strD));
        System.out.println("String E: " + strE + " - String F: " + strF + " - are equal? : " + perm.permutation(strE, strF));
    }

}
