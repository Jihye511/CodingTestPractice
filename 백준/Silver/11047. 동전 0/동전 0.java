import java.util.*;
import java.io.*;

public class Main{
    static int n,k;
    static Integer[] coin;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new Integer[n];
        for(int i =0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        //내림차순으로 변환
        Arrays.sort(coin,Collections.reverseOrder());
        for(int i =0; i<n; i++){
            if(k == 0) break;
            if(k /coin[i] >0){
                cnt += k /coin[i];
                k = k % coin[i];
            }
        }
        System.out.println(cnt);
    }
}