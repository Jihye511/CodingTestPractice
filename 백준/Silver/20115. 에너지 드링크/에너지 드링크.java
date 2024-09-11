import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static Integer[] amount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        amount = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            amount[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(amount, Collections.reverseOrder());
        long before=0;
        double sum=amount[0];
        for(int i =1; i<n; i++){
            sum += (double)amount[i]/2;
        }
        System.out.println(sum);
    }
}