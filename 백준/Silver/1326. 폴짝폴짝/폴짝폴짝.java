import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        int[] bridge = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a =  Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a == b) {
            System.out.println(0);
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        visited[a] = true;
        q.offer(new int[]{a,0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int jump = cur[1];
            if(idx == b){
                System.out.println(jump);
                return;
            }
            int step = bridge[idx];
            for(int i = idx + step; i <= N; i+= step){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(new int[]{i,jump+1});
                }
            }
            for(int i = idx - step; i >= 1; i-=step){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(new int[]{i,jump+1});
                }
            }
        }
        System.out.println(-1);
    }
}