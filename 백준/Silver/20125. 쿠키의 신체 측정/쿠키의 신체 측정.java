import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] col = new int[n];
        boolean found = false;
        int bx=0, by=0; // 심장 좌표
        for(int i =0; i<n; i++){
            String str = br.readLine();
            int cnt =0;
            for(int j =0; j<n; j++){
                char temp = str.charAt(j);
                  //연속된 * 갯수
                if(temp =='_') map[i][j] = 0;
                else {
                    if(!found){ //심장으 ㅣy축 찾음
                        found = true;
                        by = j;
                        bx = i+1;
                    }
                    cnt++;
                    map[i][j] = 1;
                    col[i]++;
                }

            }
        }
        //왼쪽, 오른쪽 팔 길이
        // 왼팔
        int leftArm = 0;
        for(int i = by-1; i >= 0 && map[bx][i] == 1; i--){
            leftArm++;
        }

        // 오른팔
        int rightArm = 0;
        for(int i = by+1; i < n && map[bx][i] == 1; i++){
            rightArm++;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(bx+1).append(" ").append(by+1).append("\n");
        sb.append(leftArm).append(" ").append(rightArm).append(" ");
        //허리 길이
        int waist = 0;
        int wx = bx + 1;
        while(wx < n && map[wx][by] == 1){
            waist++;
            wx++;
        }
        sb.append(waist).append(" ");

        //왼쪽다리
        int left = 0;
        int lx = wx;
        while(lx < n && by-1 >= 0 && map[lx][by-1] == 1){
            left++;
            lx++;
        }
        sb.append(left).append(" ");

        // 오른쪽 다리
        int right = 0;
        int rx = wx;
        while(rx < n && by+1 < n && map[rx][by+1] == 1){
            right++;
            rx++;
        }
        sb.append(right).append(" ");


        System.out.println(sb);
    }

}