def sol(a_mod, b_mod, c_mod,a,b,c,N):
    for x in range(a_mod + 1):
        for y in range(b_mod + 1):
            for z in range(c_mod + 1):
                if a*x + b*y+ c*z == N:
                    return 1
    return 0
import sys

input = sys.stdin.readline

a,b,c,N = map(int,input().split())

a_mod = N//a +1
b_mod = N//b + 1
c_mod = N//c +1
print(sol(a_mod,b_mod,c_mod,a,b,c,N))