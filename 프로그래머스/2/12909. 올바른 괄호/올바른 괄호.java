import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> q =new LinkedList<>();
        char[] ch = new char[s.length()];
        for(int i =0; i<s.length(); i++){
            ch[i] = s.charAt(i);
            q.offer(ch[i]);
        }
        if(q.peek() ==')') return false;
        boolean check=false;
        int num=0;
        while(!q.isEmpty()){
            char c = q.poll();
            if(c =='('){
                num +=1;
            }else{
                num-=1;
            }
            
            if(num<0) return false;
            
            
        }
        if(num ==0) return true;
        else return false;
        
      
    }
}