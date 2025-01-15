import java.io.*;
import java.util.*;
class Solution{
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());


        for(int T =1; T<=t; T++){
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i =0; i<n; i++){
                String str = br.readLine();
                for(int j =0; j<n; j++){
                    map[i][j] =str.charAt(j)-'0';
                }
            }
            int sum=0;
            int temp = n/2;
            for(int i =0; i<=temp; i++){
                for(int j =temp-i; j<=temp+i; j++){
                    sum +=map[i][j];
                }
            }
            for(int i =temp+1; i<n; i++){
                for(int j = i-temp; j<n-(i-temp); j++){
                    sum+= map[i][j];
                }
            }
            System.out.println("#" + T+" "+sum);
        }


    }
}