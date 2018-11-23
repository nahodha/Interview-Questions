package strings;

/**
 * Write a method to replace all spaces in a string with '%20'. Assume
 * the string has sufficient space at the end of the string to hold
 * additional characters, and that the true length of the string is
 * given.
 *
 * EXAMPLE
 * Input:  "Welcome to the jungle      "
 * Output: "Welcome%20to%20the%20jungle"
 */
public class StringReplace {

    /**
     *
     * @param word - String, the word that is to be replaced
     * @param length - int representing the true length of the string
     * @return - String, with spaces replaced with %20
     */
    public String strReplace(String word, int length) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            char current = word.charAt(i);

            if (Character.isWhitespace(current)) {
                sb.append("%20");
            } else {
                sb.append(current);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringReplace s = new StringReplace();

        String str = s.strReplace("Welcome to the jungle      ", 21);

        System.out.println(str);
    }

}
