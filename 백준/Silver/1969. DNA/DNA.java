import java.util.*;
import java.io.*;

public class Main{
    static int N,M,hd;
    static String[] S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new String[N];
        for(int i =0; i<N; i++){
                S[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();

        for(int j =0; j<M; j++){
            int[] count = new int[4];
            for(int i =0; i<N; i++){
                char a =S[i].charAt(j);
                if(a == 'A') count[0]++;
                else if(a == 'C') count[1]++;
                else if(a =='G') count[2]++;
                else if(a == 'T') count[3]++;
            }
            //count젤 큰거 뽑기
            int max =0;
            int maxIndex =0;
            for(int k =0; k<4; k++){
                if(max< count[k] || (count[k] == max && k <maxIndex)){
                    max =count[k];
                    maxIndex =k;
                }
            }
            if(maxIndex ==0) sb.append('A');
            else if(maxIndex == 1) sb.append('C');
            else if(maxIndex ==2) sb.append('G');
            else sb.append('T');

            hd += (N -max);
        }
        System.out.println(sb.toString());
        System.out.println(hd);
        }
    }