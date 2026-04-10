import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k =  Math.abs(Long.parseLong(br.readLine()));
        if(k == 0) {
            System.out.println(0);
            return;
        }
        if(k % 2 == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(Long.toBinaryString(k).length());
    }
}