package strings;

/**
 * Implement a method to perform basic string compression using the
 * counts of repeated characters. EXAMPLE aaaabbbbbddd would be
 * a4b5d3. If the compressed string is not shorter than the original
 * string the return the original string.
 */
public class StringCompress {

    /**
     * Compress string by keeping track of previous characters and its
     * count. If the next character doesn't match the previous one
     * add the previous and count to the StringBuffer, then reset
     * the previous and count variables.
     *
     * @param word - String to be compressed
     * @return - String compressed or original
     */
    public String compress(String word) {
        StringBuffer sb = new StringBuffer();

        if (countCompression(word) >= word.length()){
            return word;
        }

        char prev = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        int count = 0;

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);

            if (prev != current) {
                sb.append(prev);
                sb.append(count);

//                reset the counter and prev
                count = 1;
                prev = current;
            } else {
                count += 1;
            }

        }
        sb.append(last);
        sb.append(count);

        return sb.toString();
    }

    int countCompression(String word) {
        if (word == null || word.length() == 0)
            return 0;

        int size = 0;
        int count = 1;
        char last = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);

            if (current == last) {
                count += 1;
            } else {
                size += String.valueOf(count).length() + 1;
                count = 1;
                last = current;
            }
        }

        size += String.valueOf(count).length() + 1;

        return size;

    }

    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        System.out.println(sc.countCompression("   k             k"));
        System.out.println(sc.compress("aaddaaaaaa"));
        System.out.println(sc.compress("abcd"));
        System.out.println(sc.compress("   k             k"));
        System.out.println("");
    }
}
