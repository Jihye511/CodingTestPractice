import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static char[] work;
    static int blue, red, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        work = new char[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        for(int i =0; i<n; i++){
            work[i] = str.charAt(i);
        }
        char before ='X';
        for(int i =0; i<n; i++){
            if(work[i] !=before){
                if(work[i] =='R') red++;
                else if(work[i] =='B') blue++;
                before =work[i];
            }
        }
        cnt = Math.min(red,blue) +1;
        System.out.println(cnt);
    }
}