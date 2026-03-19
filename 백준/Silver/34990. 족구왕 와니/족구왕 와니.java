import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] players = new int[n][4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            players[i][0] = Integer.parseInt(st.nextToken());
            players[i][1] = Integer.parseInt(st.nextToken());
            players[i][2] = Integer.parseInt(st.nextToken());
            players[i][3] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        boolean isSkip = false;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            if(isSkip){
                isSkip = false;
                continue;
            }
            int bestSkill = -1;
            int kickID = -1;
            for(int j = 0; j < n; j++){
                long dx = players[j][0] - tx;
                long dy = players[j][1] - ty;
                long range = (long) players[j][2] * players[j][2];

                if(dx * dx + dy * dy <= range){
                    if(players[j][3] > bestSkill){
                        bestSkill = players[j][3];
                        kickID = j;
                    }
                }
            }
            if(kickID == -1){
                isSkip = true;
            }
            else {
                if(kickID == 0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}