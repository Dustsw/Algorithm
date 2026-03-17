import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 3) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int mid = N / 2;
        sb.append(mid + 1).append("\n");
        for (int i = 1; i < mid; i++) {
            sb.append(i).append("\n");
        }
        for (int i = mid + 2; i <= N; i++) {
            sb.append(i).append("\n");
        }
        sb.append(mid).append("\n");
        System.out.print(sb);
    }
}