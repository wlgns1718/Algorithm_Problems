import sys


input = sys.stdin.readline

def sol(word):
    global tri

    if tri:
        return

    #모두 제거 되면 리턴
    if len(word) == 0:
        tri = True
        return
    #제거 못하면 리턴
    if len(word) < 2:
        return
    #01이면 제거
    if word[:2] == "01":
        sol(word[2:])
    elif word[:3] == "100":
        temp = word[2:]
        while temp[0] == "0":#1이 될 때까지 0제거
            temp = temp[1:]
            if len(temp) == 0:
                return
        #1이 되면
        while temp[0] == "1":

            temp = temp[1:]
            if len(temp) == 0:
                tri = True
                return
            #10으로 끝난다면
            if len(temp) > 2 and temp[:2] == "10":

                sol(temp)
        #1이 다 제거된 상태
        sol(temp)
        pass
    else:#제거가 불가능한 상태
        return
n = int(input())

for _ in range(n):
    pattern = input().strip()
    tri = False
    sol(pattern)
    if tri:
        print("YES")
    else:
        print("NO")