import java.io.*;
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        // ArrayList<char> list = new ArrayList<>();
        char[] c=  s.toCharArray();;
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for( char ans : c){
            sb.append(ans);
        }
        sb.reverse();
        answer = sb.toString();
        return answer;
    }
}