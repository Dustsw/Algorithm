import java.io.*;
import java.util.*;

public class Main {
    static class Rule{
        int write;
        int nextState;
        int move;
        public Rule(int write, int nextState, int move) {
            this.write = write;
            this.nextState = nextState;
            this.move = move;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        int cState = init.charAt(0) - 'A';
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Rule[][] rules = new Rule[16][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int curState = st.nextToken().charAt(0) - 'A';
            int read = Integer.parseInt(st.nextToken());
            int write = Integer.parseInt(st.nextToken());
            int nextState = st.nextToken().charAt(0) - 'A';
            int move = Integer.parseInt(st.nextToken());

            rules[curState][read] = new Rule(write,nextState,move);
        }
        int[] tape = new int[L];
        String s = br.readLine();
        int tapeMask = 0;
        for(int i = 0; i < L; i++) {
            tape[i] = s.charAt(i) - '0';
            if(tape[i] == 1) {
                tapeMask |= 1 << i;
            }
        }

        int header = 0;
        boolean[][][] visited = new boolean[16][L][1 << L];
        while(true){
            if(header < 0 || header >= L) {
                System.out.println("STOP");
                break;
            }
            if(visited[cState][header][tapeMask]) {
                System.out.println("CONTINUE");
                break;
            }
            visited[cState][header][tapeMask] = true;
            int readValue = tape[header];
            Rule r = rules[cState][readValue];

            if(r == null){
                System.out.println("STOP");
                break;
            }

            if (tape[header] != r.write) {
                tape[header] = r.write;
                tapeMask ^= (1 << header);
            }
            cState = r.nextState;
            header += r.move;
        }
    }
}