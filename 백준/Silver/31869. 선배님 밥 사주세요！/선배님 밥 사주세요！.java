import java.io.*;
import java.util.*;

public class Main {
    static class Plan {
        String name;
        int week;
        int day;
        int price;
        public Plan(String name, int week, int day, int price) {
            this.name = name;
            this.week = week;
            this.day = day;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        Map<String, Plan> plans = new HashMap<>();
        StringTokenizer st;
        for(int i  = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int week = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            plans.put(name, new Plan(name, week, day, price));
        }
        
        for(int i  = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());

            if(plans.get(name).price > money ){
                plans.remove(name);
            }
        }

        boolean[][] visited = new boolean[11][7];
        for(Plan p : plans.values()){
            visited[p.week][p.day] = true;
        }

        int cnt = 0;
        int max = 0;

        for(int i  = 1; i <= 10; i++){
            for(int j  = 0; j < 7; j++){
                if(visited[i][j]){
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else{
                    cnt = 0;
                }
            }
        }
        System.out.println(max);


    }
}