import math

def m1(idx):
    global number, num_case, temp_num, tri, N, answer
    if idx == N:
        number = "".join([str(num_case[qwe]) for qwe in range(N)])
        answer.append(int(number))
        return
    for i in range(1, 10):
        number = ""
        tri = True
        if idx == 0 and i == 1:
            continue
        for j in range(idx):
            number += str(num_case[j])
        number += str(i)
        temp_num = int(number)
        for t in range(2, int(math.sqrt(temp_num)) + 1):
            if temp_num % t == 0:
                tri = False
                break
        if tri:
            num_case[idx] = i
            m1(idx + 1)
        else:
            continue

N = int(input().strip())
num_case = [0] * N
answer = []
m1(0)
for ans in answer:
    print(ans)
