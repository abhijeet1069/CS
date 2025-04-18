package leetcode.linkedList;

import java.util.Arrays;

public class SpiralMatrixIV {

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initialize the matrix with the desired dimensions
        int[][] resultMatrix = new int[m][n];

        // Fill the matrix with -1 to indicate unfilled cells
        for (int[] row : resultMatrix) {
            Arrays.fill(row, -1);
        }

        // Initialize row and column indices to start from the top left corner
        int row = 0, column = 0;

        // Initialize the direction index
        int directionIndex = 0;

        // Define the directions for right, down, left, and up in a 2D array
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Continue to fill the matrix until the linked list is exhausted
        while (head != null) {
            // Fill the current cell with the linked list's node value
            resultMatrix[row][column] = head.val;

            // Move to the next node in the linked list
            head = head.next;

            // Determine the new coordinates based on the current direction
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            // Check for boundary conditions and if the next cell is already filled
            if (nextRow < 0 || nextColumn < 0 || nextRow >= m ||
                    nextColumn >= n || resultMatrix[nextRow][nextColumn] >= 0) {
                // Change the direction if we hit a boundary or a filled cell
                directionIndex = (directionIndex + 1) % 4;
            } else {
                // Update the row and column indices if the next cell is valid
                row = nextRow;
                column = nextColumn;
            }
        }

        // Return the filled spiral matrix
        return resultMatrix;
    }

    public static boolean isValidMove(int[][] matrix, int i, int j){
        int row = matrix.length;
        int col = matrix[0].length;
        if(i>=row || i < 0 || j>=col || j < 0 || matrix[i][j] >= 0)
            return false;
        return true;
    }

    public static void printMatrix(int[][] arr){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    public static void printList(ListNode head){
        System.out.println();
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        int m = 3, n = 5;
        printMatrix(spiralMatrix(m,n,head));
    }
}
