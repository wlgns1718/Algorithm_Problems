T = int(input())
for test_case in range(1,T+1):
    total_sum = 0
    N, M = map(int,input().split())
    N_list = list(map(int, input().split()))
    M_list = list(map(int, input().split()))
    if N > M:
        i = 0
        while i+M<=N:
            temp = 0
            for j in range(M):
                temp += M_list[j] * N_list[i+j]
            total_sum = max(total_sum,temp)
            i += 1
        print(f'#{test_case} {total_sum}')
    else:
        i = 0
        while i+N <=M:
            temp = 0
            for j in range(N):
                temp += N_list[j] * M_list[i+j]
            total_sum = max(total_sum,temp)
            i += 1
        print(f'#{test_case} {total_sum}')