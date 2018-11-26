package arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees.
 */
public class RotateImage {

    /**
     * Loop through the column and rows. when looping the columns start
     * looping in reverse order while setting the new array to the
     * rotated values.
     * Rotation is achieved by interchanging the row column positions
     * then copying the new row column values to the new positions in
     * reverse.
     *
     * EXAMPLE:
     * Assume the matrix is of size 2x2
     * The value at position 0,0 is assigned the value previously at
     * position 0,1 and
     * The value currently at position 1,0 is assigned to position 1,1
     * OR
     * Assume the matrix is size 6x6
     * The value at position 3,4 in the matrix is assigned the value
     * previously at position 4,3 and
     * The value at position 4,5 in the matrix is assigned the value
     * previously at position 5,2
     *
     * @param matrix - String NxN array to be rotated 90deg
     * @return - String NxN array rotated 90 deg
     */
    public String[][] rotate90(String[][] matrix) {
        String[][] newArr = new String[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                newArr[j][i] = matrix[i][Math.abs(j - (matrix[i].length - 1))];
            }
        }

        return newArr;

    }

    /**
     * loop through row and each column in the row to print each character.
     *
     * @param matrix - String NxN array
     */
    public void printArr(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();

        String[][] arr = {
                {"a", "b"},
                {"c", "d"}
        };

        String[][] arr2 = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"}
        };


        ri.printArr(arr);
        System.out.println();
        ri.printArr(ri.rotate90(arr));

        System.out.println();

        ri.printArr(arr2);
        System.out.println();
        ri.printArr(ri.rotate90(arr2));

    }

}
