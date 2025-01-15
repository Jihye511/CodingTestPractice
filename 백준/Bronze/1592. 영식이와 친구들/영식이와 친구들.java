import java.io.*;
import java.util.*;

public class Main {
    static int n,m,l;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        p = new int[n];
        int num =0;
        int cnt=0;
        while(true){
            p[num]++;
            if(p[num]==m) break;


            if(p[num]%2==1){
                //l만큼 시계방향
                num=(num+l) %n;
            }else if(p[num]%2 ==0){
                //l만큼 반시계
                num = ((num-l) +n)%n;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}