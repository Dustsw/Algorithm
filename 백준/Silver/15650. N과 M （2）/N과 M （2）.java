import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(1,0);
        System.out.println(sb);
    }
    static void dfs(int at, int depth){
        if(depth == M){
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = at; i <= N; i++){
            arr[depth] = i;
            dfs(i+1,depth+1);
        }
        return;
    }
}