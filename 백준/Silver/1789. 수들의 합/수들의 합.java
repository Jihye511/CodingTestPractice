import java.io.*;
import java.util.*;
public class Main{

    static long S,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());
        long k=1;
        long sum=0;
        while (true){
            sum+=k;
            if(sum >S){
                break;
            }
            else k++;
        }
        System.out.println(k-1);
    }
}