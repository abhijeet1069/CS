package ctci.bigO.theory;

public class CheckPrime {

    public static boolean isPrime(long n){
        for(long x = 2; x*x <= n; x++){
            if(n%x == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        for(long n = 2; n < 2000; n++){
            if(isPrime(n))
                System.out.println(n);
        }

    }
}
