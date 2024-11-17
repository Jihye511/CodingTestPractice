import java.io.*;
import java.util.*;
class Solution {
    
    public int solution(String name) {
        int result = 0;
        int move = name.length() - 1;
        
        for(int i =0; i<name.length(); i++){
            result += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A') );
            
            //연속된 'A' 가 끝나는 지점 찾기
            int next = i+1;
            while(next<name.length() && name.charAt(next) =='A'){
                next++;
            }
            
            //좌우이동 최소 횟수 구하기(순서대로 va 뒤로 돌아가기)
            move = Math.min(move, (i*2) + name.length() - next);
            move = Math.min(move, (name.length()-next)*2 +i);
        }
        result +=move;
        return result;
    }
    
}