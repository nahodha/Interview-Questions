package arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
public class SetZero {

    /**
     * Use a boolean array of the same size to track which position has
     * a zero in it and then loop through a second time to fill in
     * those positions with zeroes.
     *
     * @param arr - int[][] to be replaced with zeroes
     * @return - int[][]  with zeroes replaced
     */
    public int[][] setZeroes(int[][] arr) {

        boolean[][] tracker = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    tracker[i][j] = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (tracker[i][j]) {
                    for (int k = 0; k < arr.length; k++) {
                        arr[k][j] = 0;
                    }
                    for (int k = 0; k < arr[i].length; k++) {
                        arr[i][k] = 0;
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

        int[][] arr3 = {{2,4,3,2,5},
                {3,6,0,9,9},
                {0,3,9,8,6},
                {5,4,3,2,1}};

        sz.printArr(sz.setZeroes(arr1));
        sz.printArr(sz.setZeroes(arr2));
        sz.printArr(sz.setZeroes(arr3));
    }

}
