import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // 배열로 쪼개기
        int cnt=0;
        char[] c = s.toCharArray();
        if(c[0] =='(' && c[c.length-1] ==')'){
            for(int i =0; i<c.length; i++){
                if(c[i] =='(') cnt ++;
                else if(c[i]==')') cnt --;
                
                if(cnt<0) answer =false;
            } 
            if(cnt != 0) answer = false;
        }else answer = false;
        
        return answer;
    }
}