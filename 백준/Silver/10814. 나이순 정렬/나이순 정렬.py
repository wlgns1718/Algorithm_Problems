import sys

input = sys.stdin.readline

dict = {str(i):[] for i in range(1,201)}

N = int(input())

for _ in range(N):
    a,b = map(str,input().split())
    dict[a].append(b)
for key,val in dict.items():
    if not len(val):
        continue
    for i in val:
        print(key, i)