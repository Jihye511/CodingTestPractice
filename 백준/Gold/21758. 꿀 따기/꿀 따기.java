import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] map;
    static int rightBeeMax=0;
    static int leftBeeMax =0;
    static int max=0;
    static int[] idxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        idxSum = new int[N];
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        idxSum[0] = map[0];
        for(int i =1; i<N; i++){
            idxSum[i] = idxSum[i-1] + map[i];
        }

        case1();
        case2();
        case3();
        System.out.println(max);
    }
    public static void case1(){

        //벌1 맨왼쪽 고정 , 벌집 맨 오른쪽 고정, 벌2 가운데 이동

        for(int i =1; i<N-1; i++){ //벌2 이동
            int bee1 =idxSum[N-1] - map[i] - map[0];
            int bee2 =idxSum[N-1]-idxSum[i];

            max = Math.max(bee1+bee2,max);
        }
    }
    public static void case2(){
        //벌집 맨 왼쪽 고정, 벌1 맨 오른쪽고정, 벌 2 가운데 이동
        for(int i=1; i<N-1; i++){
            int bee1 = idxSum[N-2] - map[i];
            int bee2 = idxSum[i-1];
            max = Math.max(bee1+bee2,max);
        }
    }
    public static void case3(){
        //벌1 맨 오른쪽고정, 벌 2 맨 왼쪽 고정, 벌집 가운데 이동
        for(int i=1; i<N-1; i++) { // 벌집
            int bee1 = idxSum[i] - map[0];
            int bee2 = idxSum[N - 2] - idxSum[i - 1];

            max = Math.max(bee1 + bee2, max);

        }

    }
}
