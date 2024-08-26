import java.util.*;
import java.io.*;

public class Main{
    static int a,b,c,d,e,f;
    static int x,y;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        a =Integer.parseInt(str[0]);
        b =Integer.parseInt(str[1]);
        c =Integer.parseInt(str[2]);
        d =Integer.parseInt(str[3]);
        e =Integer.parseInt(str[4]);
        f =Integer.parseInt(str[5]);
        x =0;
        y =0;
        for(int i =-999; i<=999; i++){
            for(int j =-999; j<=999;j++ ){
                if((a*i +b*j == c) && (d*i + e*j ==f)){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.println(x +" " +y);
    }

}