import sys
input = sys.stdin.readline

T = int(input())

for tc in range(1,T+1):
    a, b = map(int, input().split())
    print('Case #{0}: {1} + {2} = {3}'.format(tc, a, b, a+b))