N,X = map(int,input().split())
n_list = list(map(int, input().split()))
for i in range(N):
    if n_list[i]<X:
        print(n_list[i],end=" ")