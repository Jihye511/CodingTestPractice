class Solution {
    public int solution(long num) {
        int answer = -1;
        int cnt=0;
        for(int i =0; i<500;i++){
            if(num ==1){
                answer = cnt;
                break;
            }
            if(num %2==0){
                num /=2;
                cnt ++;
            }
            else{
                num = num*3 +1;
                cnt++;
            }
            
        }
        return answer;
    }
}