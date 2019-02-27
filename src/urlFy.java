import java.io.*;
import java.util.Scanner;

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
space at the end to hold the additional characters, and that you are given the "true" length
of the string.
(Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 */


public class urlFy {

    void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0, index, i = 0;
        for(i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if(trueLength < str.length) str[trueLength] = '\0';
        for(i = trueLength - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {

        urlFy url = new urlFy();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        String userString = scanner.nextLine();
        char[] charString = userString.toCharArray();

        System.out.println("Please enter a fixed int length: ");
        int fixedLength = scanner.nextInt();

        System.out.println("You entered: " + fixedLength);

        url.replaceSpaces(charString,fixedLength);

        String finalUrl = new String(charString);

        System.out.println();
        System.out.println("String Urlified: " + finalUrl);


    }
}
