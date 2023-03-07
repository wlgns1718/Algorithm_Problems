import sys

input = sys.stdin.readline

ls = []

for _ in range(9):
    ls.append(int(input()))
ls.sort()
start = 0
end = 8
diff  = sum(ls) - 100
while True:
    if ls[start] + ls[end] > diff:
        end -=1
    elif ls[start] + ls[end]<diff:
        start += 1
    else:
        break
for i in range(9):
    if i== start or i == end:
        continue
    print(ls[i])