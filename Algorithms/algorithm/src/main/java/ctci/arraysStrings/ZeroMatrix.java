package ctci.arraysStrings;

public class ZeroMatrix {

    static void printMatrix(int[][] matrix){
        System.out.println();
        for (int[] row : matrix) {
            for (int i : row)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    static void setZero(int[][] matrix, int row, int col){
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        if(row >= rowSize)
            return;
        if(col >= colSize)
            return;
        for(int i = 0; i < rowSize; i++)
            matrix[i][col] = 0;
        for(int i = 0; i < colSize; i++)
            matrix[row][i] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,2,3},{3,0,5}};
        printMatrix(matrix);
        for(int i = 0; i < matrix.length; i++ ){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0)
                    setZero(matrix,i,j);
            }
        }
        printMatrix(matrix);
    }
}
