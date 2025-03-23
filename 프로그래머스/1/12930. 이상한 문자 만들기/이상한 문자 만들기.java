import java.io.*;
class Solution {
    public String solution(String s) {
        String ans="";
        char[] c =new char[s.length()];
        boolean check = false;
        for(int i =0; i<s.length(); i++){
            c[i] = s.charAt(i);
            if(c[i]==' '){
                ans += c[i];
                check =false;
                continue;
            }
            else if(!check){
                //짝수(false)면 대문자
                ans += Character.toUpperCase(c[i]);
            }else{
                //소문자
                ans += Character.toLowerCase(c[i]);
                
            }
            check = !check;
        }
        return ans;
    }
}