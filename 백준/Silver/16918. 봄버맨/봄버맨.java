import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map =new char[R][C];
        int[][] bombtime = new int[R][C];

        for(int i =0; i<R; i++){
            String tmp = br.readLine();
            for(int j =0; j<C; j++){
                map[i][j] =tmp.charAt(j);
                if(map[i][j] == 'O'){
                    bombtime[i][j] = 3;
                }
            }
        }
        int time = 0;
        int[] dx ={-1,1,0,0};
        int[] dy ={0,0,-1,1};

        while(time++<N){
            if(time%2==0) { // 비어있는 칸에 폭탄 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time + 3;
                        }
                    }
                }
            }else if(time%2==1){// 시간이 다 된 폭탄 터트림
                for(int i =0; i<R; i++){
                    for(int j =0; j<C; j++){
                        if(bombtime[i][j] == time){
                            map[i][j] ='.';
                            for(int k =0; k<4; k++){
                                int nx = i+dx[k];
                                int ny = j+dy[k];

                                if(nx <0 || ny <0 || nx>=R || ny>=C) continue;

                                if(map[nx][ny] =='O' && bombtime[nx][ny] != time){
                                    map[nx][ny] ='.';
                                    bombtime[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i =0; i<R; i++){
            System.out.println(map[i]);
        }

    }
}