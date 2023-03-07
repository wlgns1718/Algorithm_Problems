import sys

input = sys.stdin.readline

K, N = map(int, input().split())
cable = []
for _ in range(K):
    cable.append(int(input()))
start = 1
end = (2 ** 31) - 1
temp = 0
while True:
    mid = (start+end)//2
    if mid == temp:
        break
    temp = mid
    cnt = 0
    for i in cable:
        cnt += i//mid
    if cnt < N:
        end = mid-1
    elif cnt >= N:
        start = mid+1

print(mid)