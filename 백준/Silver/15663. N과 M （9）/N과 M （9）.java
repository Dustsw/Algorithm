import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, input;
    static boolean[] visited;
    static Set<String> set;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        set = new LinkedHashSet<>();
        dfs(0);
        for (String s : set) {
            System.out.println(s);
        }
    }
    static void dfs(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}