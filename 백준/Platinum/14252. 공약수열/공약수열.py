def gcb(a,b):
    while True:
        if a%b == 0:
            return b
        tmp = a
        a = b
        b = tmp%b
def sol(a,b):
    for i in range(a,b+1):
        if (gcb(a,i) == 1) and (gcb(b,i) == 1):
            return 1
    else:
        return 2

import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int,input().split()))
arr.sort()
answer = 0
for i in range(len(arr)-1):
    if gcb(arr[i],arr[i+1]) == 1:
        continue
    else:
        answer += sol(arr[i],arr[i+1])

print(answer)

