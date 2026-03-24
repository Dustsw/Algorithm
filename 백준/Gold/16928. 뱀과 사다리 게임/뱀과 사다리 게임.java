import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        boolean[] visited = new boolean[101];

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u] = v;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == 100){
                System.out.println(cur[1]);
                break;
            }
            for(int i = 1; i <= 6; i++){
                int next = cur[0] + i;
                if(next <= 100){
                    if(map[next] != 0){
                        next = map[next];
                    }
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(new int[]{next, cur[1] + 1});
                    }
                }
            }
        }
    }
}