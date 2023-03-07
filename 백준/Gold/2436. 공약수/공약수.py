def gcd(a,b):
    while True:
        temp = b
        b = a%b
        a = temp
        if b == 0:
            return a
import sys
input = sys.stdin.readline

a,b = map(int,input().split())

div = b//a
x,y = 1,div
for i in range(2,div//2 + 1):
    if (i>div//i):
        break
    if div % i ==0:
        if gcd(div//i,i) ==1:
            if x+y > i+(div//i):
                x = i
                y = (div//i)

print(x*a, y*a)