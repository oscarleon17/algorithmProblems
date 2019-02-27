import java.io.*;

/*
Is Unique: implement and algorithm to determine if a string has all unique characters. What if you cannot use
additional data structures?

Ask if String is Ascii (128 chars) or unicode, extended ascii (256 chars)? Shows expertise.
 */

public class isUnique {

    private boolean isUniqueCharacters(String str){

        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0 ){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {

        isUnique isUnique = new isUnique();

        String str = "hellomynameis";
        String str1 = "abcdefghijk";

        System.out.println("String 1: " + str + " is " + isUnique.isUniqueCharacters(str));
        System.out.println("String 2: " + str1 + " is " + isUnique.isUniqueCharacters(str1));
    }
}
