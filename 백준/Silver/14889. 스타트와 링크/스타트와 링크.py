from itertools import combinations
N = int(input())
skill = [list(map(int,input().split())) for _ in range(N)]
ls = [i for i in range(N)]

answer = 99999999

for i in combinations(ls,N//2):
    start = 0
    link = 0
    for player in range(N):
        if player in i:
            for temp in i:
                start += skill[player][temp]
        else:
            for temp in range(N):
                if temp in i:
                    continue
                link += skill[player][temp]
    temp1 = abs(link - start)
    if answer > temp1:
        answer = temp1
print(answer)