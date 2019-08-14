package LeetCode.Easy;

public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] A = {{1,1,0}, {1,0,1}, {0,0,0}};
        A = flipAndInvertImage(A);
        printMatrix(A);
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int[] temp = new int[A[0].length];

        for (int r = 0; r < A.length; r++) {
            for (int c = A[0].length - 1, index = 0; c >= 0; c--, index++) {
                int value = A[r][c];
                value = value == 1 ? 0: 1; // invert
                temp[index] = value;
            }
            A[r] = temp;
            temp = new int[A[0].length];
        }

        return A;
    }

    public static void printMatrix(int[][] A) {
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) { // A[0] because magic.
                System.out.print(A[r][c] + " ");
            }
            System.out.println();
        }
    }
}
