class Solution {
    public String solution(String s) {
        String answer = "";
        char[ ] c = s.toCharArray();
        if(s.length() %2!=0){
            answer += c[s.length()/2];
        }
        else{
            answer +=c[s.length()/2-1];
            answer +=c[s.length()/2];
        }
        return answer;
    }
}