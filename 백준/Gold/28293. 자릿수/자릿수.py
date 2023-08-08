import sys
import math
input = sys.stdin.readline

a,b = map(int,input().split())
temp = b * math.log10(a)
print(int(temp+1))