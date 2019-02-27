import java.util.*;

public class missingWords {

    public static List<String> mWords(String s, String t) {

        String[] s2 = s.trim().split("\\s+");
        String[] t2 = t.trim().split("\\s+");
        ArrayList<String> missing = new ArrayList<>();

        int i = 0 ,j = 0;
        for(; i < s2.length; i++){
            if(j == t2.length){
                break;
            }
            if (!s2[i].equals(t2[j])){
                missing.add(s2[i]);
            } else {
                j++;
            }
        }

        for (; i < s2.length; i++){
            missing.add(s2[i]);
        }

        System.out.println(Arrays.toString(missing.toArray()));

        return missing;
    }

    public static void main(String[] args) {

        mWords("I am using HackerRank to improve programming", "          HackerRank to improve"); //Passes
        //mWords("Iam oscar and am cool","am oscar and"); //Works
        //mWords("hello my name is oscar","MY NAME IS");
        //mWords("","");
        //mWords("", "word");
    }
}
