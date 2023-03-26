import sys
input = sys.stdin.readline

def sol(idx,select,answer):
    if idx == N:
        temp_s = 1
        temp_b = 0
        cnt = 0
        for i in range(N):
            if select[i] == False:
                cnt += 1
                continue
            temp_s *= s[i]
            temp_b += b[i]
        if cnt != N:
            answer.append(abs(temp_s-temp_b))
        return
    select[idx] = True
    sol(idx+1,select,answer)
    select[idx] = False
    sol(idx+1,select,answer)



N = int(input())
s=[]
b=[]
for _ in range(N):
    a, c = map(int,input().split())
    s.append(a)
    b.append(c)
select = [False] * N
answer = []
sol(0,select,answer)
print(min(answer))