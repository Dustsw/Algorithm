import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[111];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 110; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 110; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 110; i++) {
            if (isPrime[i]) primes.add(i);
        }

        for(int i = 0; i < primes.size(); i++){
            int res = primes.get(i) * primes.get(i+1);
            if(res > n){
                System.out.println(res);
                break;
            }
        }

    }
}