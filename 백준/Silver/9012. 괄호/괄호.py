import sys
N = int(sys.stdin.readline())
for i in range(N):
    sol = []
    err = 0
    strs = sys.stdin.readline().strip()
    strs_list = list(strs)
    for val in strs_list:
        if len(sol) > 0 and val ==')':
            sol.pop()
        elif val =='(':
            sol.append(val)
        else:
            err = 1
            break
    if err == 0 and len(sol) == 0:
        print('YES')
    else:
        print('NO')