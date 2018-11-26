package arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees.
 */
public class RotateImage {

    /**
     * Assume the matrix is square.
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
