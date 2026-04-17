import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] input, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        dfs(0,0);
        System.out.println(sb.toString());
    }
    static void dfs(int idx, int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        int before = -1;
        for(int i = idx; i < N; i++){
            int cur =  input[i];
            if(before != cur){
                before = cur;
                arr[depth] = cur;
                dfs(i ,depth+1);
            }
        }
    }
}