import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] quest =  new int[N];
        for (int i = 0; i < N; i++) {
            quest[i] = Integer.parseInt(st.nextToken());
        }
        int L = Integer.parseInt(br.readLine());

        long low = 0;
        long high = 1_000_000_000L;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) {
                if(mid >= quest[i]) {
                    total += mid;
                }
                else{
                    total += 2 * (mid - quest[i]);
                }
            }
            if(total >= L){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}