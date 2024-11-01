import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int N,C;
    static int[] arr;
    static boolean[] check;

    static int result = Integer.MIN_VALUE;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N];
        for(int i =0; i<N; i++){
            arr[i] =Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //이분탐색
        System.out.println(binary());

    }
    public static int binary(){
        int start = 1;
        int end = arr[N-1]- arr[0]+1;
        while(start<end){
            int mid = (start+end)/2;
            if(checkNum(mid) <C){
                //공유기가 지정된 c보다 적으면 거리 줄여야됨
                end = mid;
            }else{
                //크거나 같으면 거리 줄이기
                start = mid+1;
            }
        }
        return start-1;
    }
    public static int checkNum(int dist){
        int before=arr[0];
        int count=1;
        for(int i =1; i<N; i++){
            if(arr[i] -before >= dist){
                count++;
                before = arr[i];
            }
        }
        return count;
    }

}