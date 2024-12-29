import sys
import math as m
input = sys.stdin.readline

N = int(input())

for _ in range(N):
    a, b, c = map(float, input().split(" "))
    res1 = (-b + m.sqrt(b*b - (4 * a * c))) / (2 * a)
    res2 = (-b - m.sqrt(b*b - (4 * a * c))) / (2 * a)
    print(f"{res1:.3f}, {res2:.3f}")