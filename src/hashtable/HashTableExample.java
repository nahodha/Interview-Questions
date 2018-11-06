package hashtable;

/**
 * Simple implementation of the Hashtable data structure
 * using really simple linear probing technique.
 * For simplicity purposes we store integers.
 * We store the data in an array.
 */
public class HashTableExample {

    private int arrSize = 200;

    private Integer[] hashtable = new Integer[arrSize];

    private HashTableExample(int data) {
        put(data);
    }

    /**
     * To hash we get the modulus of the input integer and the
     * array size. If some data already exists in the position,
     * keep checking the next until we find an empty spot or the
     * we find data already exists or the counter == arrSize.
     *
     * @param data integer to be stored in the hashtable
     * @return int position where the data was stored on the array
     */
    private int hash(int data) {
        int hashcode = data % arrSize;

        if (hashcode < 0)
            hashcode *= -1;

        return hashcode;
    }

    /**
     * To store the data using quadratic probing add the hashcode to
     * an incrementing counter which is squared then the modulus found
     * is the new hash.
     *
     * @param hashcode the position to be checked for availability
     * @param data the data to be stored if there is a position open
     * @return position where data is stored or -1
     */
    private int store(int hashcode, int data) {
        if (hashtable[hashcode] == null || hashtable[hashcode] == data) {
            hashtable[hashcode] = data;
            return hashcode;
        }

        int newHash;

        for (int i = 1; i < arrSize; i++) {
            newHash = (hashcode + i * i) % arrSize;

            if (hashtable[newHash] != null) {
                continue;
            }

            hashtable[newHash] = data;
            return newHash;

        }

        return -1;

    }

    /**
     * Hash the data and return the position.
     *
     * @param data integer that we want to store in the hashtable
     * @return position where data was stored
     */
    public boolean put(int data) {
        return store(hash(data), data) > -1;
    }

    public int get(int data) {
        int hashcode = hash(data);

        if (hashtable[hashcode] == null) {
            return -1;
        }

        if (hashtable[hashcode] == data) {
            return hashcode;
        }

        int newHash;

        for (int i = 1; i < arrSize; i++) {
            newHash = (hashcode + i * i) % arrSize;

            if (hashtable[newHash] == null) {
                return -1;
            }

            if (hashtable[newHash] == data) {
                return newHash;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        HashTableExample ht = new HashTableExample(3);
        ht.put(2);
        ht.put(-4);
        ht.put(5);
        ht.put(10212);

        System.out.println("3 located at position " + ht.get(3));
        System.out.println("-4 located at position " + ht.get(-4));
        System.out.println("5 located at position " + ht.get(5));
        System.out.println("10212 located at position " + ht.get(10212));
        System.out.println("-23 located at position " + ht.get(-23));
    }
}
