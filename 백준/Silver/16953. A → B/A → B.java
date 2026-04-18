import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a =  Long.parseLong(st.nextToken());
        long b =  Long.parseLong(st.nextToken());
        
        int count = 1;
        while(b!=a){
            if(b<a){
                System.out.println("-1");
                return;
            }
            if(b%10 == 1){
                b /= 10;
            }
            else if(b % 2 == 0){
                b /= 2;
            }
            else{
                System.out.println("-1");
                return;
            }
            count++;
        }
        System.out.println(count);
    }
}