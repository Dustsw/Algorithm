import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] oddSum = new int[N / 2 + 1];
        int[] evenSum = new int[N / 2 + 1];

        int oddIdx = 1, evenIdx = 1;
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            if(i % 2 != 0){
                oddSum[oddIdx] = oddSum[oddIdx - 1] + cards[i];
                oddIdx++;
            }
            else{
                evenSum[evenIdx] = evenSum[evenIdx - 1] + cards[i];
                evenIdx++;
            }
        }

        int ans = oddSum[N/2];

        for(int i = 1; i<= N/2; i++){
            int tmp = oddSum[i - 1] + cards[N] + (evenSum[N/2 - 1] - evenSum[i-1]);
            ans = Math.max(ans, tmp);

            int tmp2 = oddSum[i] + (evenSum[N/2 - 1] - evenSum[i-1]);
            ans = Math.max(ans, tmp2);
        }
        System.out.println(ans);
    }
}