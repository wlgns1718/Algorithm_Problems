import sys
input = sys.stdin.readline
N = int(input())
answer = 0
for i in range(1,N+1):
    temp = str(i)
    triger = 0
    differ = 10
    for j in range(len(temp)-1):
        a = int(temp[j])
        b = int(temp[j+1])
        if differ == 10:
            differ = (a-b)
            continue
        if differ != (a-b):
            triger = 1
    if triger ==0:
        answer += 1
print(answer)