N = int(input())
sub = []

sub = list(map(int,input().split()))
maxscore = max(sub)
#조작
for i in range(N):
    sub[i]=(sub[i]/maxscore)*100
ave = sum(sub)/N
print(ave)
