package hashtable;

import java.util.Arrays;

/**
 * Simple implementation of the Hashtable data structure
 * using really simple linear probing technique.
 * For simplicity purposes we store integers.
 * We store the data in an array.
 */
public class HashTableExample {

    private int arrSize = 100;

    private int[] dataStore = new int[arrSize];

    private HashTableExample(int data) {
        Arrays.fill(dataStore, -1);
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
        int counter1 = 0;

        int mod = data % arrSize;

        if (mod < 0)
            mod *= -1;

        if (dataStore[mod] == -1 || dataStore[mod] == data) {
            dataStore[mod] = data;
            return mod;
        }

        int counter2 = mod + 1;

        while (counter1 < arrSize) {
            if (counter2 > arrSize) {
                counter2 = 0;
                continue;
            }
            if (dataStore[counter2] == data) {
                return counter2;
            }

            if (dataStore[counter2] == -1) {
                dataStore[counter2] = data;
                return counter2;
            }

            counter2++;
            counter1++;
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
        int res = hash(data);

        return res > -1;
    }

    public int get(int data) {
        return hash(data);
    }

    public static void main(String[] args) {
        HashTableExample ht = new HashTableExample(3);
        ht.put(2);
        ht.put(4);
        ht.put(5);
        ht.put(103);

        System.out.println("result 3 : " + ht.get(3));
        System.out.println("result 4 : " + ht.get(4));
        System.out.println("result 5 : " + ht.get(5));
        System.out.println("result 103 : " + ht.get(103));
    }
}
