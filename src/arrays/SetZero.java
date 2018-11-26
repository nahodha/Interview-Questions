package arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
public class SetZero {

    /**
     * Loop through row and column and when one position has a 0
     * loop through its specific column and specific row replacing all
     * positions with zeroes.
     *
     * @param arr - int[][] to be replaced with zeroes
     * @return - int[][]  with zeroes replaced
     */
    public int[][] setZeroes(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 0; k < arr[0].length; k++) {
                        arr[i][k] = 0; // reset everything in that column with 0
                    }
                    for (int l = 0; l < arr.length; l++) {
                        arr[l][j] = 0; // reset everything in that row with 0
                    }
                }
            }
        }

        return arr;

    }

    /**
     * loop through row and each column in the row to print each character.
     *
     * @param matrix - String NxN array
     */
    public void printArr(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SetZero sz = new SetZero();

        int[][] arr1 = {{0,2,4},
                        {2,3,5},
                        {4,4,3}
                       };

        int[][] arr2 = {{2,4,3,2,5},
                        {3,6,0,9,9}};

        sz.printArr(sz.setZeroes(arr1));
        sz.printArr(sz.setZeroes(arr2));
    }

}
