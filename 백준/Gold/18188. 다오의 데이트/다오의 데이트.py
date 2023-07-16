import copy
import sys

input = sys.stdin.readline

def sol(idx,dir,x,y):
    global tri, answer

    if tri:
        return
    if world[x][y] == "Z":
        tri = True
        answer = dir
        return
    if idx == N:
        return
    for m in move[idx]:
        if m == "W": #위로 가는 경우
            if x-1 >= 0 and world[x-1][y] != "@":
                copy_dir = copy.deepcopy(dir)
                sol(idx + 1,copy_dir+"W", x-1, y)
        elif m == "D":
            if y + 1 < W and world[x][y+1] != "@":
                copy_dir = copy.deepcopy(dir)
                sol(idx + 1, copy_dir + "D", x, y+1)
        elif m == "A":
            if y-1 >= 0 and world[x][y-1] != "@":
                copy_dir = copy.deepcopy(dir)
                sol(idx + 1, copy_dir + "A", x, y-1)
        elif m == "S":
            if x + 1 < H and world[x+1][y] != "@":
                copy_dir = copy.deepcopy(dir)
                sol(idx + 1, copy_dir + "S", x+1, y)






H, W = map(int,input().split()) # 2,3

world = []

# 2 3
# .@.
# D.Z
# 2 움직일 수 있는 횟수
# W D #첫 번째 움직일 수 있는 방향
# W S #두 번째 움직일 수 있는 방향

for i in range(H):
    temp = input().strip()
    world.append(list(temp))
N = int(input())
move = [list(map(str,input().split())) for _ in range(N)]
tri = False
answer = ""
for i in range(H):
    for j in range(W):
        if world[i][j] == "D":
            sol(0, "", i, j)
            break


if not tri:
    print("NO")
else:
    print("YES")
    print(answer)