import java.util.*;
import java.io.*;

public class Main{
    static int a,b;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while(true){
            if(a ==b) break;
            if(b % 10 == 1){
                //1삭제
                b = b/10;
                cnt++;
            }
            else if(b%2 ==0){
                //짝수이면 나누기 2
                b = b/2;
                cnt ++;
            }
            else{
                System.out.println("-1");
                return;
            }
            if(a>b){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(cnt+1);
    }
}