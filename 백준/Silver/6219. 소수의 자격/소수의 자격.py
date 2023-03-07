import sys
input = sys.stdin.readline

A, B, D = map(str,input().split())
a = int(A)
b = int(B)

ls = [1] * (b+1)

for i in range(2, int(b**0.5)+1):
    if ls[i]:
        for j in range(i+i,b+1,i):
                ls[j] = 0
prime = [i for i in range(a,b+1) if ls[i]]
cnt = 0
for n in prime:
    if D in str(n):
        cnt += 1
print(cnt)