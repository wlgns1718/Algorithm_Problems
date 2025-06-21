A = []
A_1 = [] # 120도 시계 방향
A_1_2 = []
A_2 = [] # 120도 반 시계 방향
A_2_2 = []
A_3 = [] # 대칭
B = []
count = []
N = int(input())

for i in range(N) :
    A.append(list(map(int,input().split())))
for i in range(N) :
    B.append(list(map(int,input().split())))

for i in range(1,len(A)+1): # 시계방향 대칭
    t = []
    for j in range(0,len(A)) :
        try :
            t.insert(0, A[j][-i])
        except : pass
    A_1.insert(0,t)

for i in range(len(A)): # 반시계방향 대칭
    t = []
    for j in range(0,len(A)) :
        try :
            t.append(A[j][i])
        except : pass
    A_2.insert(0,t)

for i in range(len(A)) : # 시계 방향으로 120 회전 후 대칭
    A_1_2.append(A_1[i][::-1])

for i in range(len(A)) : # 반 시계 방향으로 120 회전 후 대칭
    A_2_2.append(A_2[i][::-1])

for i in range(len(A)) : # 그냥 대칭
    A_3.append(A[i][::-1])

A = sum(A, [])
A_1 = sum(A_1, []) # 시계 120 회전
A_1_2 = sum(A_1_2, []) # 시계 120 회전 후 대칭
A_2 = sum(A_2, []) # 반시계 120 회전
A_2_2 = sum(A_2_2, []) # 반시계 120 회전 후 대칭
A_3 = sum(A_3, []) # 그냥 대칭
B = sum(B, [])

c = 0
for i in range(len(A)) :
    c += B[i] ^ A[i]
count.append(c)

c = 0
for i in range(len(A_1)) :
    c += B[i] ^ A_1[i]
count.append(c)

c = 0
for i in range(len(A_3)) :
    c += B[i] ^ A_1_2[i]
count.append(c)

c = 0
for i in range(len(A_2)) :
    c += B[i] ^ A_2[i]
count.append(c)

c = 0
for i in range(len(A_3)) :
    c += B[i] ^ A_2_2[i]
count.append(c)

c = 0
for i in range(len(A_3)) :
    c += B[i] ^ A_3[i]
count.append(c)

print(min(count))