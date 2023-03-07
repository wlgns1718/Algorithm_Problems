import sys

input = sys.stdin.readline
answer = 1
for _ in range(3):
    answer *= int(input())
string = str(answer)

dict = {str(i):0 for i in range(10)}

for i in string:
    dict[i] += 1
for i in dict.values():
    print(i)