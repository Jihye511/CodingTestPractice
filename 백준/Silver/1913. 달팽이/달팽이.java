import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = Integer.parseInt(br.readLine());

        play(N,num);
    }

    public static void play(int N, int num){
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[N][N];
        int limit = 1; // 이동 칸 수
        int value= 1; //현재 숫자
        int x = N/2;
        int y = N/2;

        int x_value =0, y_value=0; // num의 인덱스 값찾기

        while(true){
            //위로 올라가는
            for (int i =0; i<limit; i ++){
                map[x--][y] = value++;
            }

            //N*N이면 스탑
            if(value>N*N){
                break;
            }
            //오른쪽 이동
            for(int i =0; i<limit; i++){
                map[x][y++] = value++;
            }
            limit++;

            //아래 이동
            for(int i =0; i<limit; i++){
                map[x++][y] = value++;
            }
            //왼쪽이동
            for(int i =0; i<limit; i++){
                map[x][y--] = value++;
            }
            limit++;
        }

        //두번째 인풋값에 대한 인덱스 찾기
         for(int i =0; i<N; i ++){
             for (int j =0; j<N; j++){
                 sb.append(map[i][j] +" ");
                 if( num == map[i][j]){
                    x_value = i +1;
                    y_value = j +1;
                 }
             }
             sb.append("\n");
         }
        sb.append(x_value+" "+y_value);
        System.out.println(sb.toString());



     }
}