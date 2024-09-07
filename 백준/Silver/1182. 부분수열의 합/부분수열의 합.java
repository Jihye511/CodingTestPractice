import java.util.*;
import java.io.*;

public class Main{
    static int n,s;
    static int[] value;
    static int cnt;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        if(n<1 || n>20){
            return;
        }
        s = Integer.parseInt(st.nextToken());
        value = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if(s ==0){
            System.out.println(cnt-1);
        }else{
            System.out.println(cnt);
        }
    }
    public static void dfs(int index,int sum){
        if(index ==n){//모든 인덱스 확인했다면
            if(sum == s){
                cnt +=1;
            }
            return;
        }
        dfs(index+1, sum+value[index]); //현재 원소 선택
        dfs(index+1,sum);   //현재 원소 선택 x
    }
}