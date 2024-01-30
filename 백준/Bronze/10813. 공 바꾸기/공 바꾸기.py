n,m = map(int, input().split())
# 바구니 번호대로 공 번호  집어 넣기
# 리스트는 0번부터 바구니는 1번부터 시작
list = [i for i in range(1,n+1)]
# 바꿀 공번호 i, j 입력 받아 서로 교환
for a in range(m):
    i,j = map(int, input().split())
    list[i-1],list[j-1]=list[j-1],list[i-1]
# 공 번호 출력    
for b in range(n):
    print(list[b], end=' ')