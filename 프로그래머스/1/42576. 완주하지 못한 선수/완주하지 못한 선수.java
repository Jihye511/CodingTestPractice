import java.io.*;
import java.util.*;
class Solution {
    
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                return answer;
            }
        }
        
        // 마지막에 남는 선수는 participant 배열의 마지막 요소
        return participant[participant.length - 1];
    }
}