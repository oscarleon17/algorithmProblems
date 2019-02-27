//decodeReverseASCII takes a reversed string (e.x. olleh vs hello) in ASCII that is composed of only a-z 
//and A-Z characters (65-90 and 97-122, respectively), as well as space characters (32), and then decodes
//the string of numbers into a string of characters.

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class decodeReverseASCII {

    public static String decode(String encoded){

        char[] asciiArr = encoded.toCharArray(); // decomposes string into a byte array
        int i = 0; // Used to keep track of array length
        int j = encoded.length() - 1; // Gets the length of the string provided by user - 1
        while (i < j) { // While statement, reverses string provided
            char temp = asciiArr[i]; // Temp statement, stores current [i] of char array
            asciiArr[i] = asciiArr[j]; // We set the current [i] to be the last value of the array, or [j]
            asciiArr[j] = temp; // We set the current [j] to be temp, culminating the current [i] [j] reversal
            i++; // Increase i, to go to the next character
            j--; // Decrease j to go to the previous character
        } // Time complexity so far = O(n), where n is the number of characters in String

        // At this point, the string provided as input is completely reversed. We can
        // now start decoding...!

        // To start we create a HashMap that will act as our dictionary for the ascii values/keys

        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            {
                int i = 65;
                for (char ch = 'A'; ch <= 'Z'; ++ch) {
                    put(i++, String.valueOf(ch));
                }
                i = 97;
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    put(i++, String.valueOf(ch));
                }
                put(32, String.valueOf(' '));
            }
        };


        StringBuilder sb = new StringBuilder();         //String builder used to store the current values of the encoded string
        StringBuilder decoded = new StringBuilder();    //Used to store the final decoded value

        int x = 0;                                      //Used to iterate through the ascii array (by using it's length)

        while (x < asciiArr.length) {                   //Start of while loop, we are now iterating through the ascii values one by one

            String asciiString = new String(asciiArr);  //A copy of the encoded string, in String form
            sb.append(asciiString.charAt(x));           //We start appending the values of the encoded string, one by one, to sb
            String temp = sb.toString();                //Temporary string holder, it converts sb to String
            Object tempInt = Integer.valueOf(temp);     //Object that converts temp from String to Int

            if (map.get(tempInt) != null) {             //Checks if current tempInt is a Key inside our HashMap
                decoded.append(map.get(tempInt));       //If tempInt is in hashMap, append to decoded String Builder
                sb.setLength(0);                        //Reset sb to length 0, as we have obtained a value from our HashMap
            }
            x++;                                        //Increment x by one to keep iterating through encoded string
        }

        return String.valueOf(decoded);                 //Return decoded string
    }

//    public static void main(String[] args) {
//
//        decodeReverseASCII testing = new decodeReverseASCII();
//        String encoded = "2312179862310199501872379231018117927";
//        decode(encoded);
//    }
}
