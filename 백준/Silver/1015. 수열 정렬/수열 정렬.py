import sys

N = int(sys.stdin.readline())

a = map(int,sys.stdin.readline().split(" "))
ls_a = [i for i in a]
ls_idx = sorted(ls_a)
for i in ls_a:
    idx = ls_idx.index(i)
    print(idx,end=" ")
    ls_idx[idx] = -1