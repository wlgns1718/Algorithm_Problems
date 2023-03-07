a,b,c,d,e,f = map(int,input().split())

x = int(((c*e-f*b)/(a*e-b*d)))
y = int(((f*a-c*d)/(a*e-d*b)))
print("{} {}".format(x,y))