import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static List<List<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        visited = new boolean[N + 1];
        arr = new int[N + 1];
        dfs(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }
    static void dfs(int cur){
        visited[cur] = true;
        for(int next : tree.get(cur)) {
            if(!visited[next]) {
                arr[next] = cur;
                dfs(next);
            }
        }
    }
}