import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int threshold = (int) Math.ceil(0.9 * m);
        int[] cnt = new int[1000001];
        for (int i = 0; i < m; i++) {
            cnt[a[i]]++;
            if (cnt[a[i]] >= threshold) {
                System.out.println("YES");
                return;
            }
        }
        for (int i = m; i < n; i++) {
            int next = a[i];
            int prev = a[i-m];
            cnt[next]++;
            cnt[prev]--;
            if (cnt[next] >= threshold) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}