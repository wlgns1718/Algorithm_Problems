import sys
input = sys.stdin.readline
answer = ''
temp = ''
T = int(input())
for _ in range(T):
    STR = str(input())
    if not answer:
        temp = STR
        answer = STR
    for i in range(len(temp)):
        if temp[i] != STR[i]:
            if i+1 == len(temp):
                answer = answer[:i]+'?'
            else:
                answer = answer[:i]+"?"+answer[i+1:]

print(answer)