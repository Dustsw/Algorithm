import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mileage = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l =  Integer.parseInt(st.nextToken());
            Integer[] list = new Integer[p];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            if (p < l){
                mileage[i] = 1;
            }
            else{
                Arrays.sort(list, Collections.reverseOrder());
                mileage[i] = list[l-1];
            }
        }
        Arrays.sort(mileage);
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++){
            sum += mileage[i];
            if (sum > M){
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}