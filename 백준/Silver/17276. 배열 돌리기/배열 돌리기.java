import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,d;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            st = new StringTokenizer(br.readLine());
            n= Integer.parseInt(st.nextToken());
            d= Integer.parseInt(st.nextToken()); //각도
            int[][] map = new int[n][n];
            //T X T 배열 만들기
            for(int i =0; i<n; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] copy=copiedMap(map);
            //각도 음수일 때, 양수 일 때
            if(d > 0){
                right(copy);

            }else{
                left(copy);
            }
        }
    }
    //시계방향으로 돌기
    public static void right(int[][] map){
        int[][] copy = copiedMap(map);
        for(int cnt =0; cnt<Math.abs(d)/45; cnt++){
            //(i,i) 대각선 이동
            for(int i =0; i<n; i++) {
                copy[i][(n + 1) / 2 - 1] = map[i][i];
            }
            //가운데 열 부 대각선으로 이동
            for(int i =0; i<n; i++){
                copy[i][n-1-i] = map[i][(n+1)/2 -1];
            }
                //부 대각선 가운데 행으로 이동
            for(int i =0; i<n; i++){
                copy[(n+1)/2 - 1][n-1-i] = map[i][n-1-i];
            }
                //가운데 행 주 대각선으로 이동
            for(int i= 0; i<n; i++){
                copy[i][i] = map[(n+1)/2 -1][i];
            }
            map= copiedMap(copy);
        }
        print(copy);
    }
    //반시계방향으로 돌기
    public static void left(int[][] map){
        int[][] copy=copiedMap(map);

        for (int cnt = 0; cnt < Math.abs(d)/45; cnt++) {
            for (int i = 0; i < n; i++) {
                copy[(n+1)/2-1][i]=map[i][i];
            }

            for (int i = 0; i < n; i++) {
                copy[i][i]=map[i][(n+1)/2-1];
            }

            for (int i = 0; i < n; i++) {
                copy[i][(n+1)/2-1]=map[i][n-1-i];
            }
            for (int i = 0; i < n; i++) {
                copy[n-1-i][i]=map[(n+1)/2-1][i];
            }
            map=copiedMap(copy);
        }

        print(copy);
    }

    //배열 카피
    public static int[][] copiedMap(int[][] map){
        int[][] copy= new int[n][n];
        for(int i =0; i<n;i++){
            for(int j = 0; j<n; j++){
                copy[i][j]=map[i][j];
            }
        }
        return copy;
    }

    //출력
    public static void print(int[][] map){
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}