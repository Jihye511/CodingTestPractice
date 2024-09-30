import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int N= completion.length;
        for(int i =0; i<N; i++){
            if(participant[i].equals(completion[i])){
                continue;
            }
            else{
                return participant[i];
            }
        }
        return participant[N];
    }
}