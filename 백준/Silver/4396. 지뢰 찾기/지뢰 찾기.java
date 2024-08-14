import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{

    static char[][] map;
    static char[][] boom;
    static int[] dir_x = {-1,-1,-1,0,1,1,1,0};
    static int[] dir_y = {-1,0,1,1,1,0,-1,-1};
    static boolean flag = false;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n= Integer.parseInt(br.readLine());
        map= new char[n][n];
        boom= new char[n][n];

        //지뢰 지도 = boom
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n;j++){
                boom[i][j] = str.charAt(j);
            }
        }

        //연 좌표 저장 =map
        for(int i =0; i<n; i++){
            String str = br.readLine();
            for(int j =0; j<n; j++){
                map[i][j]=str.charAt(j);
            }
        }

        //정상 프로세스
        process();

        checkBoom();
        for (char[] chars : map) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void checkBoom() {
        if(flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(boom[i][j] == '*')
                        map[i][j]= '*';
                }
            }
        }
    }

    private static void process() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'x'){
                    if(boom[i][j] == '*')
                        flag = true;
                    else {
                        countBoom(i, j);
                    }
                }
                else
                    map[i][j] = '.';
            }
        }
    }

    private static void countBoom(int i, int j) {
        int count = 0;

        for (int k = 0; k < 8; k++) {
            int x = i + dir_x[k];
            int y = j + dir_y[k];
            if(0 <= x && x <= n-1 && 0 <= y && y <= n-1){
                if(boom[x][y] == '*')
                    count++;
            }
        }
        map[i][j] = (char) (count + '0');
    }

}