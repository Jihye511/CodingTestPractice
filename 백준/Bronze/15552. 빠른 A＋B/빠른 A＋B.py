import sys
T = int(input())
for x in range(T):
    A, B = map(int, sys.stdin.readline().split())
    print(A+B)