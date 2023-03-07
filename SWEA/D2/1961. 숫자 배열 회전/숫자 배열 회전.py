T = int(input())
for test_case in range(1,T+1):
    n = int(input())
    mat = [list(map(int,input().split())) for _ in range(n)]
    rotation_90 = [] #밑에서 부터 위로
    rotation_180 = [] #오른쪽 밑에서 부터 왼쪽
    rotation_270 = [] #오른쪽 위에서 부터 아래쪽
    for i in range(n):
        temp = str()
        for j in range(n-1,-1,-1):
            temp += str(mat[j][i])
        rotation_90.append((temp))
    for i in range(n-1,-1,-1):
        temp = str()
        for j in range(n-1,-1,-1):
            temp += str(mat[i][j])
        rotation_180.append((temp))
    for i in range(n-1,-1,-1):
        temp = str()
        for j in range(n):
            temp += str(mat[j][i])
        rotation_270.append((temp))
 
    print(f'#{test_case}')
    for i in range(n):
        print(rotation_90[i], rotation_180[i],rotation_270[i])