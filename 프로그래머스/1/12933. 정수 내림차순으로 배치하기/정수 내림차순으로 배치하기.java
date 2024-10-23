import java.io.*;
import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        char [] num = str.toCharArray();
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<num.length; i++){
            sb.append(num[i]);
        }
        sb.reverse();
       
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}