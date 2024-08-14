import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 일단 이차원 배열을 만들고 사회자가 숫자를 말하면 그 위치의 값이 0->1 로 바뀌는.. 식으로 작성해보자
// 아 더 깊게 가자면 철수가 만든 빙고판 배열 arr1 이랑 사회자가 부르는 배열 arr2 랑 지워지게 만드는 배열 arr3 이렇게 3개..?
//아 미친 그럴 필요 없이 그냥 철수 입력하는 배열 하나 만들어서 사회자가 숫자 부르면 그 값을 0으로 바꿔주면 되잔하...
public class Main {
    static int[][] map = new int[5][5];
    static int count = 0;
    static int bingo=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //철수 입력
        for (int i=0; i<5; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0; j<5; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //사회자가 숫자 부르기
        for (int i=0; i<5; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0; j<5; j++){
                count++;
                int num = Integer.parseInt(st.nextToken());
                bingo(num);

                bingo=0; //빙고 개수를 매번 초기화
                col();
                row();
                diag1();
                diag2();

                if(bingo >=3){
                    System.out.println(count);
                    return;
                }
            }
        }
    }
    //가로빙고 체크
    public static void row(){

        for(int i =0; i<5; i++){
            int row = 0;
            for (int j=0; j<5; j++){
                row += map[i][j];
            }
            if(row ==-5){
                bingo++;
            }

        }
    }
    //세로 빙고 체크
    public static void col(){

        for(int i =0; i<5; i++){
            int col = 0;
            for(int j=0; j<5; j++){
                col += map[j][i];
            }
            if(col==-5){
                bingo++;
            }

        }
    }
    //오른쪽 아래 대각선 빙고 체크
    public static void diag1(){
        int diag1=0;
        for(int i =0; i<5; i++){
            diag1+=map[i][i];

        }
        if(diag1==-5){
            bingo++;
        }

    }
    //왼쪽아래로 대각선 빙고 체크
    public static void diag2(){
        int diag2 =0;
        for (int i=0; i<5; i++){
            diag2+=map[i][4-i];
        }
        if(diag2==-5){
            bingo++;
        }

    }
    //부른 숫자 -1 처리
    public static void bingo(int n){
        for(int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if(map[i][j]==n){
                    map[i][j]=-1;
                }
            }
        }
    }
}