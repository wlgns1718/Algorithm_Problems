a,b,n,w = map(int,input().split())
answer = []
for i in range(1,n+1):
    for j in range(1,n+1):
        if (i+j)!=n:
            continue
        else:
            if(a*i + b*j ==w):
                answer.append([i,j])
if len(answer) >= 2 or len(answer)==0:
    print(-1)
else:
    print("{} {}".format(answer[0][0],answer[0][1]))