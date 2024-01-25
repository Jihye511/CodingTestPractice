A,B,C = map(int,input().split())

if(A==B):
    if (A==C):
        price=10000+A*1000
    else:
        price=1000+A*100
elif(B==C):
    if (B==A):
        price=10000+A*1000
    else:
        price=1000+B*100
elif(A==C):
    if (A==B):
        price=10000+A*1000
    else:
        price=1000+A*100
else:
    if A>B:
        if A<C:
            price = 100*C
        else:
            price=100*A
    elif B>C:
        if B<A:
            price = 100*A
        else:
            price=100*B
    elif C>A:
        if C<B:
            price = 100*B
        else:
            price=100*C
print(price)