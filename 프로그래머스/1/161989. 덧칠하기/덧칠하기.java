import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start=section[0];
        for(int i= 1; i<section.length; i++){
            if((start +m -1) >= section[i] ) continue;
            else{
                start = section[i];
                answer ++;
            }
        }
        return answer;
    }
}