import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static String bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        q.add(start);
        visited[start] = true;
        Arrays.fill(command, "");

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) {
                return command[cur];
            }
            int D = (cur * 2) % 10000;
            int S = cur == 0 ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur % 10) * 1000 + cur / 10;
            if (!visited[D]) {
                visited[D] = true;
                command[D] = command[cur] + "D";
                q.add(D);
            }
            if (!visited[S]) {
                visited[S] = true;
                command[S] = command[cur] + "S";
                q.add(S);
            }
            if (!visited[L]) {
                visited[L] = true;
                command[L] = command[cur] + "L";
                q.add(L);
            }
            if (!visited[R]) {
                visited[R] = true;
                command[R] = command[cur] + "R";
                q.add(R);
            }
        }
        return "";
    }
}