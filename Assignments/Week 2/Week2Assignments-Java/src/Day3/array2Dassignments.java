package Day3;
//2D array assignment


import java.util.Arrays;

public class array2Dassignments {

    static int[][] numbers = {{1,2,3},{4,5,6}};

    static int[][] numbers2 = {{1,2,3},{4,5,6}};

    public static void print2Darray(int[][] matrix){
        System.out.println(Arrays.deepToString(matrix));
    }

    public static int sum2DarrayElements(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += (matrix[i][j] + matrix[i + 1][j]);
            }
        }

        return sum;
    }

    public static int array2Dmax(int[][] matrix){
        int max = -999;

        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > max) {
                    max = ints[j];
                }
            }
        }

        return max;
    }

    public static int array2Dmin(int[][] matrix){
        int min = 999;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    public static int[] array2DRowSum(int[][] matrix){
        int[] rowsums = {0,0};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rowsums[i] += matrix[i][j];
            }
        }

        return rowsums;
    }

    public static int[] array2DColumnSums(int[][] matrix){
        int[][] t_matrix = array2Dtranspose(matrix);

        int[] columnsums = new int[t_matrix.length];

        for (int i = 0; i < t_matrix.length; i++) {
            for (int j = 0; j < t_matrix[i].length; j++) {
                columnsums[i] += t_matrix[i][j];
            }
        }

        return columnsums;
    }

    public static int[][] array2Dtranspose(int[][] matrix){
        int[][] t_matrix = new int[matrix[1].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                t_matrix[j][i] += matrix[i][j];
            }
        }

        return t_matrix;
    }

    public static int[][] array2DAdd(int[][] matrix_1, int[][] matrix_2){
        int[][] a_matrix = new int[matrix_1.length][matrix_1[1].length];

        for (int i = 0; i < matrix_1.length; i++) {
            for (int j = 0; j < matrix_1[i].length; j++) {
                a_matrix[i][j] = matrix_1[i][j] + matrix_2[i][j];
            }
        }

        return a_matrix;
    }

    static void main(){

        System.out.println(Arrays.deepToString(numbers));

        System.out.println((sum2DarrayElements(numbers)));

        System.out.println((array2Dmax(numbers)));

        System.out.println((array2Dmin(numbers)));

        int[] rowsums = array2DRowSum(numbers);

        System.out.println("Row 1 sum: " + rowsums[0] + " Row 2 sum: " + rowsums[1]);

        System.out.println("Column sums: " + Arrays.toString(array2DColumnSums(numbers)));

        print2Darray(array2Dtranspose(numbers));

        print2Darray(array2DAdd(numbers, numbers2));
    }
}
