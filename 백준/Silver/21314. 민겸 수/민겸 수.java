import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mg = br.readLine(); // MKM 

        StringBuilder max = new StringBuilder(); // 최대값
        StringBuilder min = new StringBuilder(); // 최소값

        int cntM = 0; // 연속된 M의 개수

        for(int i = 0; i < mg.length(); i++) {
            char currentChar = mg.charAt(i); // M

            if(currentChar == 'M') {
                cntM++; // 1
            }else if(currentChar == 'K') {

                // 1. 최대값 나오게
                // 501 최대
                // => MK + M 
                if(cntM > 0) { // MK
                    max.append('5'); 
                    for(int j = 0; j < cntM; j++) {
                        max.append('0'); //  M의 개수만큼 0을 추가
                    }
                }else{ // K
                    max.append('5');
                }

                // 2. 최솟값 나오게
                // 151 최소
                // => M + K + M
                if(cntM > 0) { // MK
                    min.append('1'); // M을 1로 변환
                    for(int j = 1; j < cntM; j++) {
                        min.append('0'); // 나머지 M은 0으로
                    }
                    min.append('5'); // 현재 K를 5로 변환
                }else{
                    min.append('5'); 
                }

                cntM = 0;

            }
        }

        // 남은 M 처리
        if(cntM > 0) {
            // 최대값
            for(int j = 0; j < cntM; j++) {
                max.append('1');  // 남은 M 모두 1로 변환
            }
            // 최솟값
            min.append('1');
            for(int j = 1; j < cntM; j++) {
                min.append('0'); 
            }
        }

        System.out.println(max);
        System.out.println(min);
    
    }
}