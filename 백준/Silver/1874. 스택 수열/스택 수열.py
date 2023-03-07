import sys

N = int(sys.stdin.readline())
Array = [int(sys.stdin.readline()) for _ in range(N)]
curr = 0
temp = []
sol_list = []
for i in range(1,N+1):
    temp.append(i)
    sol_list.append('+')
    while len(temp) != 0 and temp[-1] == Array[curr] :
        temp.pop()
        sol_list.append('-')
        curr += 1
if len(temp) != 0 :
    print('NO')
else:
    for i in sol_list:
        print(i)