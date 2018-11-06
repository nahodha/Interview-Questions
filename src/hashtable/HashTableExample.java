package hashtable;

/**
 * Simple implementation of the Hashtable data structure
 * using linear probing to avoid collision.
 * For simplicity purposes we store integers.
 * We store the data in an array.
 */
public class HashTableExample {

    private int arrSize = 100;
    private int dataSize = 0;
    private Integer[] hashtable = new Integer[arrSize];

    private HashTableExample(int data) {
        put(data);
    }

    /**
     * To hash we get the modulus of the input integer and the
     * array size.
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
     * Method used to store data after hashcode is generated.
     * If some data already exists in the position, keep checking
     * the next until we find an empty spot or the we find
     * data already exists or the counter is equal to arrSize.
     *
     * @param hashcode integer representing starting storage position
     * @param data integer representing data to be stored
     * @return position where data is stored.
     */
    private int store(int hashcode, int data) {
//        Check if array is full and return -1
        if (dataSize == arrSize - 1)
            return -1;

        if (hashtable[hashcode] == null || hashtable[hashcode] == data) {
            hashtable[hashcode] = data;
            dataSize += 1;
            return hashcode;
        }

        int newHash;

        for (int i = 1; i < arrSize; i++) {
            newHash = (hashcode + i * i) % arrSize;

            if (hashtable[newHash] != null) {
                continue;
            }

            hashtable[newHash] = data;
            dataSize += 1;
            return newHash;
        }

        return -1;

    }

    /**
     * Hash the data and return true if data was added
     * or false otherwise.
     *
     * @param data integer theat we want to store in the hashtable
     * @return boolean shows whether the data was stored successfully
     */
    public boolean put(int data) {
        return store(hash(data), data) > -1;
    }

    /**
     * Method to check if data is contained in the hashtable and
     * returns the specific position it's at.
     *
     * @param data The integer we are looking for in the hashtable
     * @return position where data is located.
     */
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
        ht.put(103);

        System.out.println("3 is located at position " + ht.get(3));
        System.out.println("-4 is located at position " + ht.get(-4));
        System.out.println("5 is located at position " + ht.get(5));
        System.out.println("102 is located at position " + ht.get(102));
        System.out.println("-103 is located at position " + ht.get(-103));
    }
}
