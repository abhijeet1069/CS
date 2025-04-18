package ctci.bigO.exercises;

public class PerfectSquare {

    public static int sqrtBigOLogN(int num){
        return sqrt_helper(num,1,num);
    }

    private static int sqrt_helper(int n, int min, int max){
        if(max < min)
            return -1;
        int mid = (min+max)/2;
        if(mid*mid == n)
            return mid;
        else if(mid*mid < n)
            return sqrt_helper(n,mid+1,max);
        else
            return sqrt_helper(n,min,mid-1);
    }

    public static int sqrtBigOSqrtN(int num){
        for(int guess = 1; guess*guess <= num; guess++){
            if(guess*guess == num)
                return guess;
        }
        return -1;
    }

    public static void main(String[] args){
        for(int i = 1; i < 1000; i++){
            int res = sqrtBigOSqrtN(i);
            if(res != -1)
                System.out.println(res+"^2 = "+i);
        }
    }
}
