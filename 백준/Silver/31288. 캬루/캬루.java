import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            char[] p = st.nextToken().toCharArray();

            int sum = 0;
            for(int i = 0; i < p.length; i++) {
                sum += p[i] - '0';
            }

            for(int i = 0; i < N; i++) {
                int og = p[i] - '0';

                for(int j = 0; j <= 9; j++) {
                    if(j == og) continue;
                    if(i == 0 && j == 0)  continue;

                    int newSum = sum - og + j;

                    if(newSum % 3 == 0){
                        if(N == 1 && j == 3) continue;
                        p[i] = (char)(j + '0');
                        sb.append(p).append(" 3\n");
                        p[i] = (char)(og + '0');
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}