def sol(ls,T):
    ls.sort()
    l = T//2
    return ls[l]
 
 
T = int(input())
 
ls = list(map(int,input().split()))
print(sol(ls,T))