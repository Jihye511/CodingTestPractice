import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[] arr ={9,8,7,6,5,4,3,2,1,0};
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0,0);
        Collections.sort(list);
        if(list.size()<N){
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(N-1));
    }

    public static void dfs(long num, int idx){


        if(idx==10){
            if(!list.contains(num)){
                list.add(num);
            }
            return;
        }
        dfs(num*10 + arr[idx], idx+1);
        dfs(num, idx+1);
    }
}
