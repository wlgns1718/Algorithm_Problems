import sys

input = sys.stdin.readline

N, M = map(int,input().split())
known = set()#사실로 알고 있는 사람들
ls = list(map(int,input().split()))

if ls[0] != 0 :
    for i in ls[1:]:
        known.add(i)
answer = 0
party = []
for _ in range(M):
    party.append(list(map(int,input().split()))[1:])
for _ in range(M):
    for i in party:
        tri = True
        for j in i:
            if j in known:
                tri = False
                break
        if tri:
            continue
        else:
            for j in i:
                known.add(j)
for i in party:
    tri = True
    for j in i:
        if j in known:
            tri = False
            break
    if tri:
        answer += 1
print(answer)