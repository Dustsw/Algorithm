import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int A = c - a2;
        int B = -a1;
        int C = -a0;

        if(A < 0){
            System.out.println(0);
        }
        else if(A == 0){
            if(B >= 0 && (B * n0 + C >= 0)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
        else{
            if(2 * A * n0 + B >= 0){
                if (A * n0 * n0 + B * n0 + C >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            else{
                if (B * B - 4 * A * C <= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}