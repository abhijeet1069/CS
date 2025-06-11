package discreteMaths.proofs;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    public static List<Integer> getPrimeTillN(int n){
        List<Integer> result = new ArrayList<>();
        boolean[] sieve = new boolean[n+1];
        for(int i = 2; i <= n ; i++)
            sieve[i] = true;

        for(int i = 2 ;i <= n; i++){
            for(int j = 2; i*j <= n; j++){
                sieve[i*j] = false;
            }
        }

        for(int i = 2; i <= n ; i++){
            if(sieve[i])
                result.add(i);
        }
        return result;
    }
}
