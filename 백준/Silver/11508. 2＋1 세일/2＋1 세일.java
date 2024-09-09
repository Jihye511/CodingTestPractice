import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static Integer[] arr;
    static boolean[] free;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];
        free = new boolean[n];
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int freenum = n/3;
        for(int i=1; i<=freenum; i++){
            //그룹이 형성된 것의 첫번째 값은 true로 변환
            free[i*3-1] = true;
        }
        int total=0;
        //계산하기
        for(int i =0; i<n; i++){
            if(!free[i]){
                total += arr[i];
            }
        }
        System.out.println(total);

    }
}