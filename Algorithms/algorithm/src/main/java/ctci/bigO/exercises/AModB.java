package ctci.bigO.exercises;

public class AModB {

    public static int div(int a, int b){
        int count = 0;
        int sum = b;
        //how many b can be extracted from a
        while(sum <= a){
            sum += b;
            count++;
        }
        return count;
    }

    public static int mod(int a, int b){
        if(b <= 0)
            return -1;
        int div = a/b;
        return a-div*b;
    }

    public static void main(String[] args) {
        System.out.println(mod(450,5));
        System.out.println(div(450,5));
    }
}
