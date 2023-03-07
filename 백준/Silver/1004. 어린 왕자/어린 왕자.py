import sys

T = int(sys.stdin.readline())

for _ in range(T):
    x1,y1,x2,y2 = map(int,sys.stdin.readline().split(" "))
    planet = int(sys.stdin.readline())
    cnt = 0
    for _ in range(planet):
        c1, c2, r = map(int,sys.stdin.readline().split(" "))
        a, c = (abs(x1-c1)**2), (abs(x2-c1)**2)
        b, d = (abs(y1-c2)**2), (abs(y2-c2)**2)
        if (a+b < (r**2) and c+d >(r**2)) or (a+b>(r**2) and c+d<(r**2)):
            cnt += 1

    print(cnt)