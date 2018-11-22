package strings;

import java.util.HashMap;

/**
 * Write a caesars cipher.
 * INPUT a number representing the number of shifts to be taken,
 * a colon acting as a separator and the text to be encrypted e.g.
 * '2:some text' - Encrypt the text by shifting each letter 2 places
 * The input should accept integers from -1,000,000,000 to
 * 1,000,000,000 as shifts.
 * Only letters of the alphabet and numbers will be encrypted.
 *
 * OUTPUT: the encrypted text. e.g. uqog vgzv for the above text.
 */
public class CaesarsCipher {

    /**
     * Separate the shift from the input String.
     *
     * @param words String containing the shift and text.
     * @return Integer shift.
     */
    private static int beforeColon(String words) {

        int counter = 0;
        StringBuffer sb = new StringBuffer();

        while (words.charAt(counter) != ':') {
            sb.append(words.charAt(counter));
            counter++;
        }

        return Integer.valueOf(sb.toString());

    }

    /**
     * Separate the text from the input String.
     *
     * @param words - String containing both the shift and text.
     * @return String - String after colon to be encrypted
     */
    private static String afterColon(String words) {
        int shift = beforeColon(words);
        int length;

//      Get the length of the shift to know where the actual text starts
        if (shift >= 0) {
            length = (int) Math.log10(beforeColon(words)) + 1;
        } else {
            length = (int) Math.log10((shift * -1)) + 2;
        }

        StringBuffer sb = new StringBuffer();

//       Start looping after colon
        for (int i = length + 1; i < words.length(); i++) {
            sb.append(words.charAt(i));
        }

        return sb.toString();

    }

    /**
     * Take as input shift, range of the characters and beginning and end
     * of the characters in the ascii table. Create a hashmap that contains
     * the original character and the corresponding shifted equivalent.
     *
     * @param numOffset int representing the shift
     * @param range - int representing number of characters to consider
     * @param begin - int representing start of characters in ascii table
     * @param end - int representing end of characters in ascii table
     * @return HashMap<Character, Character> - map of original characters to the shifted characters
     */
    private static HashMap<Character, Character> codeASCII(int numOffset, int range, int begin, int end) {
        HashMap<Character, Character> cipher = new HashMap<>();

        for (int i = begin; i < end; i++) {
            if (numOffset < 0)
                numOffset += range;

            int temp = i + numOffset - end;
            temp %= range;
            temp += begin;
            cipher.put((char) i, (char) temp);
        }

        return cipher;
    }

    /**
     * Using the shift create the cipher to be used to encrypt the text.
     *
     * @param shift - Integer number of positions to shift the alphabet
     * @return HashMap<Character, Character> - mapping the characters to their codes
     */
    private static HashMap<Character, Character> createCipher(int shift) {
        HashMap<Character, Character> cipher = new HashMap<>();

//      code the numbers
        cipher.putAll(codeASCII(shift % 10, 10, 48, 58));

//      code for alphabet;
        cipher.putAll(codeASCII(shift % 26, 26, 65, 91));

//      code for alphabet;
        cipher.putAll(codeASCII(shift % 26, 26, 97, 123));

       return cipher;
    }

    /**
     * Encrypt using the Caesars cypher created to return the encrypted
     * text.
     *
     * @param text - String to be encrypted
     * @return String - encrypted input String
     */
    public static String encrypt(String text) {
        HashMap<Character, Character> cipher = createCipher(beforeColon(text));
        String textToEncrypt = afterColon(text);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < textToEncrypt.length(); i++) {
            if (!cipher.containsKey(textToEncrypt.charAt(i))){
                sb.append(textToEncrypt.charAt(i));
            } else {
                sb.append(cipher.get(textToEncrypt.charAt(i)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

//        System.out.println(beforeColon("-1023:kjkjf"));
//
//        System.out.println(afterColon("-1023:this is my story this is my song?"));
//        HashMap<Character, Character> cipher = createCipher(1);
//
//        for (char key : cipher.keySet()) {
//            System.out.println(key + " : " + cipher.get(key));
//        }

        System.out.println(encrypt("-1000000:some text"));
    }
}
