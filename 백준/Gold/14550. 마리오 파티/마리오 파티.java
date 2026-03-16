import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            int[] board = new int[N +2];
            int idx = 1;
            while(idx <= N) {
                if(!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                board[idx++] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[T + 1][N +2];
            for(int[] row:dp) Arrays.fill(row, -999_999_999);

            dp[0][0] = 0;
            for(int t = 1; t <= T; t++) {
                for(int i = 1; i <= N+1; i++) {
                    for(int j = 1; j <= S; j++) {
                        int prev = i - j;
                        if(prev >= 0) {
                            int score = (i<=N) ? board[i] : 0;
                            dp[t][i] = Math.max(dp[t][i], dp[t-1][prev] + score);
                        }
                    }
                }
            }

            int ans = -999_999_999;
            for(int i = 1; i <= T; i++) {
                ans = Math.max(ans, dp[i][N+1]);
            }
            System.out.println(ans);
        }
    }
}