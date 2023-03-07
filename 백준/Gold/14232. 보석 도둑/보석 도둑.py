import sys

input = sys.stdin.readline

n = int(input())
x = n
sol = []
for i in range(2, n + 1):
    if i * i > x:
        break
    while x % i == 0:
        sol.append(i)
        x //= i
if x!=1:
    sol.append(x)
print(len(sol))
for i in sol:
    print(i, end =" ")