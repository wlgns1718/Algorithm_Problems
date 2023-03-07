import sys

n, x = map(int, input().split())

val = list(map(int, sys.stdin.readline().rstrip().split()))
sol = []
for i in range(len(val)):
    if val[i] < x:
        sol.append(val[i])
new = " ".join(map(str, sol))
print(new)
