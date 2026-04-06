import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] soldiers = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                soldiers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int str = soldiers[i][0];
                    int dex = soldiers[j][1];
                    int inte =  soldiers[k][2];

                    int cnt = 0;

                    for(int s = 0; s < N; s++){
                        if(soldiers[s][0] <= str && soldiers[s][1] <= dex && soldiers[s][2] <= inte){
                            cnt++;
                        }
                    }
                    if(cnt >= K){
                        minSum = Math.min(minSum,str+dex+inte);
                    }
                }
            }
        }
        System.out.println(minSum);
    }
}