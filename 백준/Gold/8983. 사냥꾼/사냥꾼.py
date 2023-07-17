import sys

input = sys.stdin.readline


M, N, L = map(int,input().split())

#M은 사대의 수, N은 동물의 수, L은 거리

#사대 위치 받기
gun = list(map(int,input().split()))
#동물의 위치 받기
animal = []
for _ in range(N):
    a,b = map(int,input().split())
    if b > L:
        continue
    temp = L - b
    if temp < 0:
        temp *= -1
    if a - temp < 0:
        animal.append([0,a+temp])
    else:
        animal.append([a-temp,a+temp])

catch = [False] * (max(gun)+1)
for i in gun:
    catch[i] = True

answer = 0
for i in animal:
    for j in range(i[0],i[1]+1):
        if catch[j]:
            answer += 1
            break
print(answer)