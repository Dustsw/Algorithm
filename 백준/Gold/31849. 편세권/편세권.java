import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = -1;
            }
        }

        ArrayList<int[]> room = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            room.add(new int[]{a, b, p});
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            q.add(new int[] {c, d, 0});
            map[c][d] = 0;
        }

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx > N || ny < 0 || ny > M) continue;
                if(map[nx][ny] != -1 ) continue;
                map[nx][ny] = d + 1;
                q.add(new int[] {nx, ny, d + 1});
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int[] r: room) {
            ans = Math.min(ans, r[2] * map[r[0]][r[1]] );
        }
        System.out.println(ans);
    }
}