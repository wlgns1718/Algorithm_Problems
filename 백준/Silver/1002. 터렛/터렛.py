import sys

N = int(sys.stdin.readline())
for _ in range(N):
    x1,y1,r1,x2,y2,r2 = map(int,sys.stdin.readline().split(" "))
    if x1==x2 and y1==y2 and r1 == r2:
        print(-1)
        continue
    dis = ((abs(x1-x2)**2) + (abs(y1-y2)**2))**(0.5)
    if r1 < r2:
        r1, r2 = r2, r1
    if dis > r1+r2 or dis+r2 < r1:
        print(0)

    elif dis == r1+r2 or dis+r2 == r1:
        print(1)

    elif dis < r1+r2:
        print(2)