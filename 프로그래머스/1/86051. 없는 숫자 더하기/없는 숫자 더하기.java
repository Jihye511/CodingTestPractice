import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int val: numbers){
            answer -= val;
        }
        
        return answer;
    }
}