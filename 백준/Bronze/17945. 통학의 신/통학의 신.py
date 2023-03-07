a,b = map(int,input().split())
answer = []
for x in range(-2001,2002):
    if (x**2+(2*a*x)+b) ==0:
        print(x,end=" ")