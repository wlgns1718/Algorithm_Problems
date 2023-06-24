import sys
from collections import deque

input = sys.stdin.readline
queue = deque()

def oper1(string):
    #A 뺴주기
    temp = string[:-1]
    return temp
def oper2(string):
    #B를 빼고 뒤집기
    temp = string[:-1]
    temp = temp[::-1]
    return temp

S = input().strip()
T = input().strip()
while len(S) < len(T):
    if T[-1] == "A":
        T = oper1(T)
    else:
        T = oper2(T)
if S == T:
    print(1)
else:
    print(0)