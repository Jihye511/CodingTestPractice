w= list(map(int,input().split()))
info=[1,1,2,2,2,8]
for i in range(len(w)):
    result = info[i]-w[i]
    print(result,end=' ')