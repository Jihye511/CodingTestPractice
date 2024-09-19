import java.util.*;
import java.io.*;

public class Main{
    static Long S;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Long.parseLong(br.readLine());

        int n =1;
        while(true){
            if(S>=n) {
                S -= n;
                n++;
            }else{
                break;
            }
        }
        System.out.println(n-1);
    }
}