package hashtable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * An implementation of hashtable collision handling by use of
 * separate chaining. An array of linked lists will be used to
 * store data with similar hashcodes.
 */
public class HashTableExample {

    private int arrSize = 200;
    private LinkedList<Integer>[] hashtable = new LinkedList[arrSize];

    private HashTableExample(int data) {
        init();
        put(data);
    }

    /**
     * Simple initialization function for setting up the linked lists
     * and initializing the index counter to 0.
     */
    private void init() {
        for (int i = 0; i < arrSize; i++) {
            hashtable[i] = new LinkedList<>();
            hashtable[i].addFirst(0);
        }
    }

    /**
     * The hashing mechanism used is modulus of the input integer
     * and the size of the input array.
     *
     * We store the data in a linked list and check if the linked
     * list is already storing data by looking at the head node. If
     * there is some data we check if the input data exists. If it
     * doesn't we add it to the array.
     *
     * @param data integer to be stored in the hashtable
     * @return int position where the data was stored on the array
     */
    private int hash(int data) {
        int hashcode = data % arrSize;

        if (hashcode < 0)
            hashcode *= -1;

        int dataCount = hashtable[hashcode].getFirst();
        int newDataCount = dataCount + 1;

        if (dataCount == 0) {
            hashtable[hashcode].add(dataCount + 1, data);
            hashtable[hashcode].removeFirst();
            hashtable[hashcode].addFirst(newDataCount);

            return hashcode;
        }

        for (int i = 1; i < dataCount; i++) {
            if (hashtable[hashcode].get(i) == data)
                return hashcode;
        }

        hashtable[hashcode].add(dataCount + 1, data);
        hashtable[hashcode].removeFirst();
        hashtable[hashcode].addFirst(newDataCount);

        return hashcode;

    }

    /**
     * Hash the data and return true if data was added
     * or false otherwise.
     * @param data integer that we want to store in the hashtable
     * @return boolean shows whether the data was stored successfully
     */
    public int put(int data) {
        return hash(data);
    }

    /**
     * A function for getting the data provided with the index.
     * It goes directly to the index in the array and loops through the
     * data returning all the data at that index in the array.
     * @param index specific index with all its data.
     * @return an array of integers or null
     */
    public int[] get(int index) {
        if (index > arrSize - 1)
            return null;

        LinkedList<Integer> data = hashtable[index];
        int dataCount = data.getFirst();

        if (dataCount == 0)
            return null;

        int[] chainedData = new int[dataCount];

        for (int i = 0; i < dataCount; i++)
            chainedData[i] = data.get(i + 1);

        return chainedData;

    }

    public static void main(String[] args) {
        HashTableExample ht = new HashTableExample(3);
        int pos = ht.put(2);
//        System.out.println("position: " + pos);
        pos = ht.put(202);
//        System.out.println("position: " + pos);
        pos = ht.put(4);
//        System.out.println("position: " + pos);
        pos = ht.put(-5);
//        System.out.println("position: " + pos);
        pos = ht.put(103);
//        System.out.println("position: " + pos);

        System.out.println("result 2 : " + Arrays.toString(ht.get(2)));
        System.out.println("result 4 : " + Arrays.toString(ht.get(4)));
        System.out.println("result 5 : " + Arrays.toString(ht.get(5)));
        System.out.println("result 103 : " + Arrays.toString(ht.get(103)));
    }
}
