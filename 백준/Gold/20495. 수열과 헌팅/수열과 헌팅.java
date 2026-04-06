import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        int[] ogMin = new int[N];
        int[] ogMax = new int[N];
        int[] sortMin = new int[N];
        int[] sortMax = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ogMin[i] = a - b;
            ogMax[i] = b + a;
            sortMin[i] = a - b;
            sortMax[i] = b + a;
        }

        Arrays.sort(sortMin);
        Arrays.sort(sortMax);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int minIdx = lowerBound(sortMax,ogMin[i]) + 1;
            int maxIdx = upperBound(sortMin,ogMax[i]);
            sb.append(minIdx).append(" ").append(maxIdx).append("\n");
        }
        System.out.println(sb);
    }
    static int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    static int upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}