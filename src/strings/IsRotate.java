package strings;

/**
 * Assume a method isSubString exists, which checks if a word is a
 * substring of another. Given 2 Strings, s1 and s2, write code to
 * check if s2 is a rotation of s1 using only one call to isSubString
 * EXAMPLE: "discombobulated" is a rotation of ombobulateddisc"
 */
public class IsRotate {

    /**
     * loop in reverse through s2 checking if the current character is
     * the same as the starting character of s1, the previous character
     * of s2 is same as the last character of s1 and if the following
     * character of s2 is same as the following character of s1.
     *
     * @param s1 - String representing the unrotated string
     * @param s2 - String rotated
     * @return - boolean true if rotated else false.
     */
    public boolean isRotated(String s1, String s2) {

//      If both the strings have different lengths then they can't be
//      rotations of one another. Also,
//      If the strings are exactly the same then they haven't been rotated.
        if (s1.length() != s2.length() || s1.length() < 2 || s1.equals(s2)) {
            return false;
        }

        char c1 = s1.charAt(0);
        char c2 = s1.charAt(1);
        char c3 = s1.charAt(s1.length() - 1);

        for (int i = s1.length() - 1; i >= 0; i--) {
            char current = s2.charAt(i);
            char next = s2.charAt((i + 1) % s2.length());
            char end = s2.charAt((i - 1 + s2.length()) % s2.length());

            if (current == c1 && next == c2 && end == c3) {
                if (s1.toLowerCase().contains(s2.substring(0, i).toLowerCase())) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        IsRotate ir = new IsRotate();

        System.out.println(ir.isRotated("am", "ma"));
        System.out.println(ir.isRotated("balloon", "loonbal"));
        System.out.println(ir.isRotated("df", "ffd"));
        System.out.println(ir.isRotated("prient", "intpri"));
    }
}
