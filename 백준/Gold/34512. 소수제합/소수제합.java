import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(N == 2){
            System.out.println(-1);
        }
        else if(N == 3){
            System.out.println("2 5 29");
        }
        else if(N == 4){
            System.out.println("2 2 3 17");
        }
        else if(N == 5){
            System.out.println("2 2 2 3 3");
        }
        else if(N == 6){
            System.out.println("2 2 3 3 3 5");
        }
        else if(N % 2 != 0){
            for(int i = 0; i < 3; i++) sb.append("2 ");
            for(int i = 0; i < N - 3; i++) sb.append("3 ");
            System.out.println(sb);
        }
        else if(N % 2 == 0){
            for(int i = 0; i < 6; i++) sb.append("2 ");
            for(int i = 0; i < N - 6; i++) sb.append("3 ");
            System.out.println(sb);
        }
    }
}