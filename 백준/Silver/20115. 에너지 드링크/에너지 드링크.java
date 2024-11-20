import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static int n;
    static long[] amount;
    static float max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        amount = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            amount[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(amount);

        max = amount[n-1];
        for(int i =0; i<n-1; i++){
            max =((float)amount[i]/2 +max);
        }
        System.out.println(max);

    }
}