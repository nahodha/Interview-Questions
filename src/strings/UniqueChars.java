package strings;

import java.util.HashMap;

/**
 * Question
 * Implement an algorithm to determine if a string has all unique characters.
 *
 * First Implementation will use a HashMap of characters and integers.
 * If the key exists, then the character already exists.
 */
public class UniqueChars {

    /**
     * Loop over a string while adding each character to the HashMap.
     * If the character already exists return false.
     *
     * @param word - String
     * @return - Boolean which indicates whether the String has all unique characters.
     */
    public boolean hasUniqueChars(String word) {
        HashMap<Character, Integer> characterCount = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (characterCount.containsKey(current)) {
                return false;
            } else {
                characterCount.put(current, 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        UniqueChars uc = new UniqueChars();
        System.out.println(uc.hasUniqueChars("Fog2939"));
        System.out.println(uc.hasUniqueChars("abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+-=  "));
        System.out.println(uc.hasUniqueChars(""));
        System.out.println(uc.hasUniqueChars("<>?,./"));
        System.out.println(uc.hasUniqueChars("y u j h"));
        System.out.println(uc.hasUniqueChars("1033"));
    }
}
