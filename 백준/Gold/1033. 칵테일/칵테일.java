import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int b;
        int p;
        int q;

        public Node(int b, int p, int q){
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
    static ArrayList<Node>[] graph;
    static long[] mass;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        mass = new long[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        long baseLcm = 1;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
            baseLcm *= lcm(p,q);
        }
        mass[0] = baseLcm;
        dfs(0);

        long finalGcd = mass[0];
        for (int i = 0; i < N; i++) {
            finalGcd = gcd(finalGcd, mass[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(mass[i] / finalGcd).append(" ");
        }
        System.out.println(sb);
    }
    static void dfs(int current){
        visited[current] = true;
        for(Node next: graph[current]){
            if(!visited[next.b]){
                mass[next.b] = mass[current] * next.q / next.p;
                dfs(next.b);
            }
        }
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}