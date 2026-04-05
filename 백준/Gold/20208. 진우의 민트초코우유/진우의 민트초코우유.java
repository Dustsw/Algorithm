import java.io.*;
import java.util.*;

public class Main {
    static int N,M,H;
    static int homeX, homeY;
    static List<int[]> milk = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v =  Integer.parseInt(st.nextToken());
                if(v == 1){
                    homeX = i;
                    homeY = j;
                }
                else if(v == 2){
                    milk.add(new int[] {i,j});
                }
            }
        }
        visited = new boolean[milk.size()];
        dfs(homeX,homeY,M,0);
        System.out.println(max);
    }
    static void dfs(int x, int y, int hp, int count){
        int dist = Math.abs(x - homeX) + Math.abs(y - homeY);
        if(hp >= dist){
            max = Math.max(max, count);
        }
        for(int i = 0; i < milk.size(); i++){
            if(!visited[i]){
                int[] next = milk.get(i);
                int nextX = next[0];
                int nextY = next[1];
                int distMilk = Math.abs(x - nextX) + Math.abs(y - nextY);

                if(hp >= distMilk){
                    visited[i] = true;
                    dfs(nextX, nextY, hp - distMilk + H, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}