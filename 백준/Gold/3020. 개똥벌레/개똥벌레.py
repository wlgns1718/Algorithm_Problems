import sys
from collections import Counter
input = sys.stdin.readline
N, H = map(int,input().split())

temp = [0] * (H)
idx = 1
for _ in range(N):
    a = int(input())
    idx = (idx+1)%2
    if idx == 0:
        temp[0] += 1
        temp[a] -= 1
    else:
        temp[H-a] += 1
prefix = [0]*H
for i in range(H):
    if i == 0:
        prefix[i] = temp[i]
        continue
    prefix[i] = prefix[i-1] + temp[i]
cnt = Counter(prefix)
a = min(prefix)
print(a, cnt[a])