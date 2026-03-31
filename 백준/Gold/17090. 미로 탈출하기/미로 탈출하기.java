import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[][] dp;
    static int N ,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(dfs(i,j) == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    static int dfs(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M){
            return 1;
        }
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        dp[x][y] = -1;
        
        int nx = x, ny = y;
        char c = map[x][y];
        if(c == 'U') nx--;
        else if(c == 'D') nx++;
        else if(c == 'L') ny--;
        else if(c == 'R') ny++;

        dp[x][y] = dfs(nx, ny);
        return dp[x][y];
    }
}