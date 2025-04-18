package ctci.bigO.theory;

public class ReverseArray {

    public static void reverse(int[] array){
        for(int i = 0; i < array.length/2; i++){
            int other = array.length-i-1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }

    public static void printArr(int[] arr){
        for(int x : arr)
            System.out.print(x+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,4,234,212,231,1,14};
        printArr(arr);
        reverse(arr);
        printArr(arr);
    }
}
