import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] op = br.readLine().split(" ");
                char command = op[0].charAt(0);
                int num = Integer.parseInt(op[1]);

                if (command == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (command == 'D') {
                    if (map.isEmpty()) continue;
                    
                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    int count = map.get(key);

                    if (count == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, count - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}