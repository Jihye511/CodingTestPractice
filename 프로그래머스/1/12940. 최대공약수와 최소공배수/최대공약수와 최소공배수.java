class Solution {
    public int[] solution(int n, int m) {
       int[] answer = new int[2];
        //최소공약수 찾기
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        while(true){
            int r = max %min;
            if(r ==0) {
                answer[0] = min;
                break;
            }
            max = min;
            min = r;
            
        }
        
        //최소공배수 찾기
        answer[1]= (n*m)/answer[0];
        
        
        
        return answer;
    }
}