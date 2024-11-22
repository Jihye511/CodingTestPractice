import java.io.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(int i =0;i<s.length(); i++){
             char ch = s.charAt(i);
            if(ch==' '){
                idx =0;
                sb.append(ch);
                continue;
            }else if(idx %2 ==0){
                sb.append(Character.toUpperCase(ch));
                idx++;
            }else{
                sb.append(Character.toLowerCase(ch));
                idx++;
            }
        }
        
        return sb.toString();
    }
}