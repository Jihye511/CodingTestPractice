import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Main {
    static long n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n= Long.parseLong(br.readLine());
        System.out.println(binarySearch(n));
    }
    public static long binarySearch(long num){
        long start = 0;
        long end = num;
        long result=0;
        while(start<=end){
            long mid = (start+end)/2;
            if(Math.pow(mid,2)<num){
                start = mid+1;
            }else if(Math.pow(mid,2)>=num){
                result = mid;
                end = mid-1;
            }
        }
        return result;
    }
}