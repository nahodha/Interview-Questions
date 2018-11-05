package hashtable;

import java.util.Arrays;

/**
 * Simple implementation of the Hashtable data structure
 * using linear probing to avoid collision.
 * For simplicity purposes we store integers.
 * We store the data in an array.
 */
public class HashTableExample {

    private int arrSize = 100;
    private int dataSize = 0;
    private int[] dataStore = new int[arrSize];

    private HashTableExample(int data) {
        Arrays.fill(dataStore, -1);
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

        if (dataStore[hashcode] == -1 || dataStore[hashcode] == data) {
            dataStore[hashcode] = data;
            dataSize += 1;
            return hashcode;
        }

        int counter1 = 0;
        int counter2 = hashcode + 1;

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
                dataSize += 1;
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
        int counter = 0;

        while (counter < arrSize) {

            if (dataStore[hashcode] == data)
                return hashcode;

            if (dataStore[hashcode] == -1)
                return -1;

            if (hashcode == arrSize - 1) {
                hashcode = 0;
                continue;
            }

            hashcode += 1;
            counter += 1;

        }

        return -1;
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
        System.out.println("result 102 : " + ht.get(102));
    }
}
