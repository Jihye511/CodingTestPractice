list = ['ABC', 'DEF','GHI','JKL,','MNO','PQRS','TUV','WXYZ']
word = input()

time =0
for unit in list:
    for i in unit: #list 에서 각 요소를 꺼내서 한글자씩 분리하기위해
        for j in word: #입력받은 문자를 하나씩 분리
            if i==j:#두알파벳이 같으면!
                time+=list.index(unit)+3
                
print(time)