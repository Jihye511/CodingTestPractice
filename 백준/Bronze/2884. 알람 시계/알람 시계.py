H,M = input().split()
H=int(H)
M=int(M)

if (M<45):
    if(H==0):
        H=23
        M=M +15
    else:
        H=H-1
        M=M+15
else:
    M=M-45

print(H, M)