import java.util.*;
import java.io.*;

public class Main{
    static int count,k,n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        count =0;
        for(int h =0; h<=n; h++){
            for(int m =0; m<60; m++){
                for(int s =0; s<60; s++){
                    if(h%10==k || h/10 ==k || m%10==k || m/10==k|| s%10==k || s/10 ==k){
                        count++;
                    }
                }
            }

        }
        System.out.println(count);

    }

}