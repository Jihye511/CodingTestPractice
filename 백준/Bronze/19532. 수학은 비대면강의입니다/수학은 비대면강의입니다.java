import java.io.*;
import java.util.*;
public class Main{
    static int [] var = new int[6];
    static int x,y;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<6;i++){
            var[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =-999; i<=999; i++){
            for(int j =-999; j<=999; j++){
                if(var[0]*i + var[1]*j == var[2]) {
                    if(var[3] *i +var[4]*j == var[5]){
                        x= i;
                        y =j;
                    }
                }
            }
        }
        System.out.println(x + " "+y);
    }
}