import java.util.*;
import java.io.*;

public class Main{
    static long n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());
        System.out.println(Binary(n));
        
    }
    public static long Binary(long n){
        long start =0;
        long end = n;
        long result = 0;
        while(start <= end){
            long mid = (start + end)/2;
            if(n <= Math.pow(mid,2)){
                result = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return result;
    }
}