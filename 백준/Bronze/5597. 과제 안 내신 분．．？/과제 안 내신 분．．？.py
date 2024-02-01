list =[0]*28

for i in range(28):
    list[i]=int(input())

for j in range(30):
    if j+1 in list:
        continue
    else:
        print(j+1)