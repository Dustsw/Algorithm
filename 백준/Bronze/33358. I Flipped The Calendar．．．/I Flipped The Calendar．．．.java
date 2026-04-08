import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year =  Integer.parseInt(br.readLine());

        int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) day[1] = 29;

        int prevYear = year - 1;
        int totalDay = (prevYear * 365) + (prevYear / 4) - (prevYear / 100) + (prevYear / 400);
        int weekDay = totalDay % 7 + 1;

        int total = 0;
        for(int i = 0; i < 12; i++){
            int days = day[i];
            int cell = weekDay - 1 + days;
            int row = (cell + 6) / 7;
            total += row;
            weekDay = (weekDay -1 + days) % 7 + 1;
        }
        System.out.println(total);
    }
}