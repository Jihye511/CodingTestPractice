import java.io.*;
import java.util.*;
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] n = phone_number.toCharArray();
        for(int i =0; i<phone_number.length(); i++){
            if(i>=phone_number.length()-4){
                sb.append(n[i]);
            }else{
                sb.append('*');
            }
           
        }
        answer = sb.toString();
        return answer;
    }
}