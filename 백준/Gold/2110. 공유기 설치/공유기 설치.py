import sys

input = sys.stdin.readline


N,C = map(int,input().split())

ls = []
for i in range(N):
    ls.append(int(input()))
ls.sort()

start = 0
end = 1000000000

while start <= end:
    mid = (start+end)//2
    temp = ls[0] + mid
    wifi = 1 #설치할 공유기 수
    for idx,val in enumerate(ls):
        if temp > val:
            continue
        temp = mid+val
        wifi += 1
    #설치된 공유기가 목표 보다 많을 때 혹은 같을 때
    if wifi >= C:
        #거리 늘리기
        start = mid + 1
    #설치된 공유기가 목표 보다 적을 때
    else:
        end = mid - 1
print((end+start)//2)