package strings;

/**
 * Assume a method isSubString exists, which checks if a word is a
 * substring of another. Given 2 Strings, s1 and s2, write code to
 * check if s2 is a rotation of s1 using only one call to isSubString
 * EXAMPLE: "discombobulated" is a rotation of ombobulateddisc"
 */
public class IsRotate {

    /**
     * concatenate s1 with itself and it will not matter how s2 is
     * rotated, if it is truly a rotation of s1 it will be contained
     * within s1 + s1
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

        String s1s1 = s1 + s1;

        return isSubstring(s1s1, s2);

    }

    /**
     * Uses contains to check if s2 is a substring of s1.
     *
     * @param s1 - String, main string
     * @param s2 - String, Check if is a sustring of s1
     * @return - boolean whether s2 is contained in s1
     */
    public boolean isSubstring(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    public static void main(String[] args) {
        IsRotate ir = new IsRotate();

        System.out.println(ir.isRotated("am", "ma"));
        System.out.println(ir.isRotated("balloon", "loonbal"));
        System.out.println(ir.isRotated("df", "ffd"));
        System.out.println(ir.isRotated("prient", "intpri"));
    }
}
