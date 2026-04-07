import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String dna = br.readLine();
        int[] count = new int[4];
        char[] chro = {'A', 'C', 'G', 'T'};

        for(int i = 0; i < n; i++) {
            if(dna.charAt(i) == 'A') count[0]++;
            else if(dna.charAt(i) == 'C') count[1]++;
            else if(dna.charAt(i) == 'G') count[2]++;
            else if(dna.charAt(i) == 'T') count[3]++;
        }

        int min = Integer.MAX_VALUE;
        char minChar = 'A';
        for(int i = 0; i < 4; i++) {
            if(min > count[i]) {
                min = count[i];
                minChar = chro[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n");
        for(int i = 0; i < n; i++) {
            sb.append(minChar);
        }
        System.out.println(sb);
    }
}