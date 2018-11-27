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
        int size = countCompression(word);
        if (size >= word.length()) {
            return word;
        }

        char[] compressed = new char[size];
        int pos = 0;
        char prev = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        int count = 0;

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);

            if (prev != current) {
                pos = setChar(compressed, prev, pos, count);

//                reset the counter and prev
                count = 1;
                prev = current;
            } else {
                count += 1;
            }

        }
        pos = setChar(compressed, prev, pos, count);

        return String.valueOf(compressed);
    }

    private int setChar(char[] arr, char c, int index, int count) {
        arr[index] = c;
        index++;

        char[] nums = String.valueOf(count).toCharArray();

        for (int i = 0; i < nums.length; i++) {
            arr[index] = nums[i];
            index++;
        }
        return index;
    }

    public int countCompression(String word) {
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
        System.out.println(sc.compress("aaddaaaaaa"));
        System.out.println(sc.compress("abcd"));
        System.out.println(sc.compress("   k             k"));
        System.out.println("");
    }
}
