import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static long[] dis;
    static long[] oil;
    static long pre;
    static long price;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dis = new long[n-1];
        oil = new long[n];
        st = new StringTokenizer(br.readLine());
        //거리 저장
        for(int i =0; i<n-1; i++){
            dis[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            oil[i] = Integer.parseInt(st.nextToken());
        }
        //처음 오일 값 저장
        pre = oil[0];
        price =0;

        for(int i =1; i<n; i++){
            if(pre > oil[i]){
                price += dis[i-1] * pre;
                pre = oil[i];
            }
            else if (pre<=oil[i]) {
                price += dis[i-1] *pre;
            }
        }
        System.out.println(price);

    }
}