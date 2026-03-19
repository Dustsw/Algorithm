import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] box = new int[n];
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(box);
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(box[i] >= sum){
                sum += box[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}