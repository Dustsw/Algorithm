import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        int cnt = count(n,1) + count(n, 2);
        System.out.println(cnt);
    }
    static int count(int n, int current){
        if(n==1) return current% 3 == 0 ? 1 : 0;

        int total = 0;
        for(int i=0;i<=2;i++){
            int next = current * 10 + i;
            total += count(n - 1, next);
        }
        return total;
    }
}