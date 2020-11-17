import java.util.Arrays;
public class Characters_String {

    public static void main (String[] args) {
        //===================== 1 =====================//
        //  What is the initial capacity of the following string builder?
        //  StringBuilder sb = new StringBuilder("Able was I ere I saw Elba.");
        //  Answer: 42
        //============================================//

        //===================== 2 =====================//
        //  String hannah = "Did Hannah see bees? Hannah did.";
        //
        //  What is the value displayed by the expression hannah.length()?
        //  Answer: 32.
        //
        // What is the value returned by the method call hannah.charAt(12)
        // Answer: e.
        //
        // Write an expression that refers to the letter b in the string referred to by hannah.
        // Answer: hannah.charAt(15).
        //=============================================//

        //===================== 3 =====================//
        String hi = "Hi, ";
        String mom = "mom.";

        System.out.println(hi + mom);
        System.out.println(hi.concat(mom));
        //=============================================//


        //===================== 4 =====================//
        System.out.println(Initials1( "Kalinin Nikita Vladimirovich"));
        System.out.println(Initials2( "Kalinin Vladimirovich"));
        //=============================================//

        //==================== 5 =====================//
        System.out.printf(Boolean.toString(isAnagram("pap","ap p")));
        //=============================================//
    }


    
    public static String Initials1(String name) {
        String initials = "";
        initials+=name.charAt(0);
        for (int i = 0; i < (name.length()); i++) {
            char t = name.charAt(i);
            if (name.charAt(i) == ' ') {
                initials+=name.charAt(++i);
                continue;
            }
        }
        return initials;
    }

    public static StringBuffer Initials2(String name) {
        StringBuffer initials = new StringBuffer();
        int length = name.length();

        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                initials.append(name.charAt(i));
            }
        }
        System.out.println("My initials are: " + initials);
        return initials;
    }


    public static boolean isAnagram(String anagram, String word) {
        char[] sortAnagram = anagram.replaceAll("[\\s]", "").toCharArray();
        char[] sortWord = word.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(sortAnagram);
        Arrays.sort(sortWord);
        return Arrays.equals(sortAnagram, sortWord);
    }

}
