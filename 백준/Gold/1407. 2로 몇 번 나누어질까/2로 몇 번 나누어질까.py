import sys

input = sys.stdin.readline

a,b = map(int,input().split())
a -= 1
sol = 0
a_list = [a]
b_list = [b]
while a//2>0:
    a_list.append(a//2)
    a //= 2
while b//2>0:
    b_list.append(b//2)
    b //= 2
while len(a_list) != len(b_list):
    a_list.append(0)

sol_list = []
for i,j in zip(a_list,b_list):
    sol_list.append(j-i)
for i in range(len(sol_list)-1):
    sol += (sol_list[i]-sol_list[i+1])*(2**i)
if sol_list[-1] !=0:
    sol += sol_list[-1]*(2**(len(sol_list)-1))
print(sol)