import sys

input = sys.stdin.readline

visit = set()
N = int(input())
N_num = list(map(int, input().split()))
visit.update(N_num)
M = int(input())
M_num = list(map(int,input().split()))
for i in M_num:
    if i in visit:
        print(1)
    else:
        print(0)