import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int sum=0;
    static int pre=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }
    public static int fibo(int n){
        if( n<=1) return n;
        return fibo(n-2) + fibo(n-1);
    }
}