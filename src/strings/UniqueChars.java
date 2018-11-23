package strings;

import java.util.Arrays;

/**
 * Question
 * Implement an algorithm to determine if a string has all unique characters,
 * without using new data structures.
 *
 * Second Implementation will make use of arrays to keep count of each character.
 */
public class UniqueChars {

    /**
     * Create an array with 256 characters representative of the extended ascii
     * character set. Each position should represent each character in the
     * set. The data stored will be integers representing the count. If it the
     * count is more than 1 return false as the character is repeated otherwise
     * return true.
     *
     * @param word - String
     * @return - Boolean which indicates whether the String has all unique characters.
     */
    public boolean hasUniqueChars(String word) {
        int[] characterCount = new int[256];
        Arrays.fill(characterCount, 0);

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (characterCount[current] > 0) {
                return false;
            } else {
                characterCount[current] += 1;
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
