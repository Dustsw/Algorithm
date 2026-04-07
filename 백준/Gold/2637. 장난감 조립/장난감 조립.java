import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int to;
        int count;
        public Node(int to, int count){
            this.to = to;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1];
        int[] need = new int[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph.get(X).add(new Node(Y, K));
            indegree[Y]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                q.offer(i);
                need[i] = 1;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Node next : graph.get(cur)){
                need[next.to] += need[cur] * next.count;
                indegree[next.to]--;
                if(indegree[next.to] == 0){
                    q.offer(next.to);
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(graph.get(i).isEmpty()){
                System.out.println(i + " " + need[i]);
            }
        }
    }
}