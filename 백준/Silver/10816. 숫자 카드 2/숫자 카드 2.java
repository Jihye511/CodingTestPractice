import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N,M;
    static int[] sang;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        sang = new int[N];
        for(int i =0; i<N; i++){
            sang[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sang);
        M = Integer.parseInt(br.readLine());
        card = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++){
            int c = Integer.parseInt(st.nextToken());

            card[i] = upperBound(c) - lowBound(c);
        }
        for(int i : card){
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }
    public static int lowBound(int key){
        int lo =0;
        int hi =N; //둘 다 인덱스 값
        while(lo<hi){
            int mid = (hi +lo)/2;

            if(sang[mid]>=key){
                hi = mid;
            }else{
                lo = mid+1;
            }

        }
        return lo;
    }
    public static int upperBound(int key){
        int lo =0;
        int hi =N; //둘 다 인덱스 값
        while(lo<hi){
            int mid = (hi +lo)/2;
            //key ==sang[mid]일 때, upperbound는 처음으로 초과하는 값을 찾는
            //거라 lo를 mid+1로 옮김
            if(sang[mid]>key){
                hi = mid;
            }else{
                lo = mid+1;
            }

        }
        return lo;
    }
}