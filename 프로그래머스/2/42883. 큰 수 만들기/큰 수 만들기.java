import java.io.*;
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack =new Stack<>();
        for(int i =0; i< number.length(); i++){
            int n = number.charAt(i) -'0';
            //작은 숫자가 없을때까지 pop
            while(!stack.isEmpty() && stack.peek()<n && k>0){
                stack.pop();
                k--;
            }
            
            stack.push(n);
            
        }
        while(k-->0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int n = stack.pop();
            sb.append(n);
        }
        answer = sb.reverse().toString();
        return answer;
    }
}