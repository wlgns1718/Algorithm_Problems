a,b,v = map(int,input().split())
if a==v:
    print(1)
else:
    temp = v-a
    if temp%(a-b)==0:
        print(1+temp//(a-b))
    else:
        print(2+temp//(a-b))