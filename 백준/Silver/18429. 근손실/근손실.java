import java.io.*;
import java.util.*;


public class Main {
    static int N,K;
    static int[] plus;
    static boolean[] visited;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        plus = new int[N];
        visited = new boolean[N];

        st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            plus[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,500);
        System.out.println(cnt);
    }
    public static void dfs(int day, int amount){
        if(amount<500){
            return;
        }
        if(day ==N){
            cnt +=1;
            return;
        }
        for(int i =0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
//                amount += plus[i]; //이렇게 하면 amount 값이 쌓임 호출과 함께 계산하는게 좋음
//                amount -= K;
                dfs(day+1,amount + plus[i] -K);
                visited[i] =false;
            }
        }
    }

}