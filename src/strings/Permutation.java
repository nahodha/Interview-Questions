package strings;

import java.util.Arrays;

/**
 * Given 2 strings decide if one is a permutation of the other.
 *
 */
public class Permutation {

    /**
     * Use an array the size of the extended ascii charset to ensure
     * that all the characters in word1 are in word2. To check if
     * one is a permutation of the other, create a counter for each
     * character in the array during the first loop, then decrement
     * the counter. If the counter goes below zero return false else
     * return true.
     *
     * @param word1 - String
     * @param word2 - String
     * @return - boolean true if word1 is permutation of word2
     */
    public boolean checkPerm(String word1, String word2) {
//      The 2 strings MUST be equal in length.
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] characterCount = new int[256];
        Arrays.fill(characterCount, 0);

        for (int i = 0; i < word1.length(); i++) {
            char current = word1.charAt(i);

            characterCount[current] += 1;
        }

        for (int i = 0; i < word2.length(); i++) {
            char current = word2.charAt(i);

            if (characterCount[current] <= 0) {
                return false;
            }

            characterCount[current] -= 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();

        System.out.println(p.checkPerm("10021", "10"));
        System.out.println(p.checkPerm("afdfe", "fadee"));
        System.out.println(p.checkPerm("aa a", " aaa"));
        System.out.println(p.checkPerm("-=d", "d=-"));
        System.out.println(p.checkPerm("afdfe", "fadef"));
    }

}
