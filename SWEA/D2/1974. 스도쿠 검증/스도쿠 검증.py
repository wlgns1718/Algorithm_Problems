T = int(input())
def square(sudoku):
    cnt = 0
    while cnt <= 6:
        visit = set()
        for i in range(3):
            for j in range(3):
                if sudoku[i + cnt][j + cnt] not in visit:
                    visit.add(sudoku[i + cnt][j + cnt])
                else:
                    return -1
        cnt += 3
    return 0
def line(sudoku):

    for i in range(9):
        visit_col = set()
        visit_row = set()
        for j in range(9):
            if sudoku[i][j] in visit_row or sudoku[j][i] in visit_col:
                return -1
            else:
                visit_row.add(sudoku[i][j])
                visit_col.add(sudoku[j][i])
    return 0
for test_case in range(1,T+1):
    sudoku = [list(map(int,input().split()))for _ in range(9)]
    if square(sudoku) == -1 or line(sudoku) == -1:
        print(f'#{test_case} 0')
    else:
        print(f'#{test_case} 1')