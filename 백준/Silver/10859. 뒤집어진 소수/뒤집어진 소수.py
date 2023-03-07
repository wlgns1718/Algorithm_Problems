def is_pri(N):
    for i in range(2,int(N**0.5)+1):
        if N % i == 0:
            return False
    return True
def reverse(ls):
    ls.reverse()
    temp_ls = ''
    for i in ls:
        if i =='3' or i == '4' or i =='7':
            return False
        elif i =='6':
            temp_ls+= '9'
        elif i =='9':
            temp_ls+='6'
        else:
            temp_ls += i
    temp = int(temp_ls)
    return is_pri(temp)
import sys
input = sys.stdin.readline
N = input().strip()
temp = is_pri(int(N))
if int(N) == 1:
    temp = False
if temp is True:
    N_ls = list(N)
    temp = reverse(N_ls)
    if temp is True:
        print('yes')
    else:
        print('no')
else:
    print('no')