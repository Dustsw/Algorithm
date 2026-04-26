import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        
        dijkstra(startCity);
        System.out.println(dist[endCity]);
    }
    static void dijkstra(int startCity) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(startCity, 0));
        dist[startCity] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.end;
            int curWeight = current.weight;
            
            if(dist[curNode] < curWeight) {
                continue;
            }
            for(Node next : graph[curNode]) {
                if(dist[next.end] > dist[curNode] + next.weight) {
                    dist[next.end] = dist[curNode] + next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}