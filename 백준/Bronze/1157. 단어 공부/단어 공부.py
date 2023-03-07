import sys

input = sys.stdin.readline

string = input().strip()
temp = string.upper()
ls = list(temp)
dict = {chr(i):0 for i in range(65,91)}

for i in ls:
    dict[i] += 1
max_num = max(dict.values())
answer = []
for key,value in dict.items():
    if value == max_num:
        answer.append(key)
if len(answer)==1:
    print(answer[0])
else:
    print('?')