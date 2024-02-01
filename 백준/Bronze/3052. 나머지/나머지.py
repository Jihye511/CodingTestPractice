num=[]

for i in range(10):
    su =int(input())
    num.append(su%42)
dap= list(set(num))
print(len(dap))