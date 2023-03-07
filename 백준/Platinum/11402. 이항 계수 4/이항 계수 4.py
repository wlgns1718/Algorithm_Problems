def sol(arr,brr,M):
    answer = 1
    for a,b in zip(arr,brr):
        temp_a = 1
        temp_b = 1
        if a < b:
            return 0
        for i in range(1,b+1):
            temp_b *= i
            temp_a *= (a-i+1)
        answer *= temp_a//temp_b
    return (answer%M)
import sys
input = sys.stdin.readline

N,K,M = map(int,input().split())

N_list=[]
K_list = []
idx = 1
temp = M
while N > temp:
    temp *= M
    idx += 1
for i in range(idx - 1, -1, -1):
    N_list.append(N // (M ** i))
    N %= (M ** i)
for i in range(idx - 1, -1, -1):
    K_list.append(K // (M ** i))
    K %= (M ** i)

print(sol(N_list,K_list,M))