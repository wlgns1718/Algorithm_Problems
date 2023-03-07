n = int(input())
answer = 0
for i in range(2,n+1,2):#택희
    temp = n-i #남은 사탕 개수
    for j in range(1,temp+1):#남규는 j 영훈은 temp - j
        a = j
        b = temp - j
        if b ==0:
            continue
        elif j >= temp-j+2:
            answer += 1
print(answer)