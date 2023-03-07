def solution(A,B,N,M):
    count = 0
    for one in range(N):
        for two in range(M):
            if A[one][two] != B[one][two]:
                for line1 in range(3):
                    for line2 in range(3):
                        if line2+two < M and line1+one < N:
                            if A[line1+one][line2+two] == '0':
                                A[line1 + one][line2 + two] = '1'
                            else:
                                A[line1 + one][line2 + two] = '0'
                        else:
                            return -1
                count += 1
    return count

N,M = map(int,input().split())
A = []
B = []
for _ in range(N):
    sample = input()
    A.append(list(sample))
for _ in range(N):
    sample_b = input()
    B.append(list(sample_b))

print(solution(A,B,N,M))