import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bulb = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case 1:
                    bulb[a] = b;
                    break;
                case 2:
                    for(int i = a; i <= b; i++) {
                        bulb[i] = 1 - bulb[i];
                    }
                    break;
                case 3:
                    for(int i = a; i <= b; i++) {
                        bulb[i] = 0;
                    }
                    break;
                case 4:
                    for(int i = a; i <= b; i++) {
                        bulb[i] = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(bulb[i] + " ");
        }
        System.out.println(sb);
    }
}