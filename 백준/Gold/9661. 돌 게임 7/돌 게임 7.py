import sys

input = sys.stdin.readline

N = int(input())

ls = [1,0,1,0,1]
if N < 4:
    answer = ls[N-1]
else:
    answer = ls[(N+1)%5]
if answer == 1:
    print("SK")
else:
    print("CY")