import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] customer;
    static long tips = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n= Integer.parseInt(br.readLine());
        customer = new int[n];

        for(int i =0; i<n; i++){
            customer[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(customer);

        for(int i=n-1; i>-1; i--){
            int tip = customer[i] - (n-i-1);
            if(tip <0){
                tip = 0;
            }
            tips += tip;
        }
        System.out.println(tips);
    }
}