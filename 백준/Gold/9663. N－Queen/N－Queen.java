import javax.imageio.ImageTranscoder;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt=0;
        int[][] v =new int[N][N];
        for(int[] i : v){
            Arrays.fill(i, -1);
        }
        backtraking( v, 0);
        System.out.println(cnt);

    }

    public static void backtraking(int[][] v, int cx){
        //x가 n에도달하면 끝
        if(cx==N) {
            cnt++;
            return;
        }

        //순서대로 탐색
        for(int i =0; i< N; i++){
            if(v[cx][i]==-1){
                int[][] a = makeVisited(v,cx,i);
                backtraking(a,cx+1);
                //풀기
                v = backtoOrigin(a, cx,i);
            }
        }
    }
    public static int[][] backtoOrigin(int[][] v, int cx, int cy){
        for(int i =0; i<N; i++) {
            if(v[cx][i] == cx){
                v[cx][i] = -1;
            }
            if( v[i][cy]==cx) {
                v[i][cy]=-1;
            }
        }
        int nx = cx;
        int ny = cy;
        while(true){
            nx +=1;
            ny +=1;
            if(nx>=N || ny>=N) break;
            if(v[nx][ny]==cx) {
                v[nx][ny] =-1;
            }
        }
        //2,4분면 대각선 채우기
        nx =  cx;
        ny = cy;
        while(true){
            nx +=1;
            ny -=1;
            if(nx>=N || ny<0 ) break;
            if(v[nx][ny] == cx) {
                v[nx][ny] = -1;
            }
        }
        return v;
    }
    public static int[][] makeVisited(int[][] v, int cx, int cy){
        v[cx][cy] = cx;
        //가로세로 채우기
        for(int i =0; i<N; i++) {
            if(v[cx][i] == -1){
                v[cx][i] = cx;
            }
            if( v[i][cy]==-1) {
                v[i][cy]=cx;
            }
        }
        //1,3분면 대각선채우기
        int nx = cx;
        int ny = cy;
        while(true){
            nx +=1;
            ny +=1;
            if(nx>=N || ny>=N) break;
            if(v[nx][ny]!=-1) continue;
            v[nx][ny] = cx;
        }
        //2,4분면 대각선 채우기
        nx =  cx;
        ny = cy;
        while(true){
            nx +=1;
            ny -=1;
            if(nx>=N || ny<0 ) break;
            if(v[nx][ny]!=-1) continue;
            v[nx][ny] = cx;
        }
        return v;
    }

}