import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int before = 0;  // 이전 작업이 완료되는데 걸리는 시간
        int count = 0;   // 동시에 배포될 작업 수

        for (int i = 0; i < progresses.length; i++) {
            // 현재 작업이 완료되는 데 걸리는 일수 계산
            int days = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days++;
            }

            // 이전 작업보다 더 많은 시간이 필요할 경우
            if (before < days) {
                // 배포할 작업이 있으면 리스트에 추가
                if (count > 0) {
                    list.add(count);
                }
                // 새로운 작업 배포 시작
                before = days;
                count = 1;  // 현재 작업이 첫 번째 배포 작업
            } else {
                // 이전 작업들과 함께 배포
                count++;
            }
        }

        // 마지막 남은 작업 배포 수 추가
        list.add(count);

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
