import sys

inout = sys.stdin.readline

N = int(input())
dice = list(map(int, input().split(" ")))

case = {(0,1,2),(0,1,3),(0,3,4),(0,2,4),(1,3,5),(1,2,5),(3,4,5),(2,4,5)}
dice_case = []
for i in case:
    dice_case.append(sorted([dice[i[0]],dice[i[1]],dice[i[2]]]))
temp = sum(min(dice_case))
test = []
for i in dice_case:
    if sum(i) == temp:
        test.append(i)
test.sort(key=lambda x:(x[0],x[1],x[2]))
if N == 1:
    dice.sort()
    print(sum(dice[:-1]))
else:
    answer = test[0][0]*(5*(N**2)-8*N+4) + test[0][1]*(8*N-8) + test[0][2]*4
    print(answer)