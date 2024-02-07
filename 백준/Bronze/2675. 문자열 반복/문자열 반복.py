T = int(input())

for _ in range(T):
    R,S = input().split()
    for x in S:
        print(x*int(R),end='')
    print()