def sol1(a_2, a_5,a):
    i = 2
    while a // i > 0:
        a_2.append(a // i)
        i *= 2
    i = 5
    while a // i > 0:
        a_5.append(a // i)
        i *= 5
    for i in range(len(a_2) - 1):
        a_2[i] -= a_2[i + 1]
    for i in range(len(a_5) - 1):
        a_5[i] -= a_5[i + 1]

def sol3(ls_2, ls_5):
    two = 0
    five = 0
    for idx, val in enumerate(ls_2):
        two += val*(idx+1)
    for idx, val in enumerate(ls_5):
        five += val*(idx+1)
    return two, five
import sys
input = sys.stdin.readline
a, b = map(int,input().split())
c = a-b
a_2, a_5 , b_2, b_5, c_2, c_5= [],[],[],[],[] ,[]
i = 2
sol1(a_2,a_5,a)
sol1(b_2,b_5,b)
sol1(c_2,c_5,c)
temp_2, temp_5 = sol3(a_2,a_5)
temp1_2, temp1_5 = sol3(b_2,b_5)
temp2_2,temp2_5 = sol3(c_2,c_5)
answer1 = temp_2 - temp1_2 - temp2_2
answer2 = temp_5 - temp1_5 - temp2_5

print(min(answer1, answer2))



