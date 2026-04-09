import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int check = b - a;
        double prob = 1.0;
        for (int i = 0; i < n; i++) {
            st =  new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int overlapStart = Math.max(a, s);
            int overlapEnd = Math.min(b, e);
            int overlap = Math.max(0, overlapEnd - overlapStart);
            prob *= (double) overlap / check;
        }
        System.out.println(1.0 - prob);
    }
}