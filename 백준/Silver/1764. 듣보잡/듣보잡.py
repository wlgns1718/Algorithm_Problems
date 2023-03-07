import sys
a, b = map(int,sys.stdin.readline().split())
listen = set()
see = set()
for _ in range(a):
    listen.add(sys.stdin.readline())
for _ in range(b):
    see.add(sys.stdin.readline())
ls = list(listen.intersection(see))
print(len(ls))
ls.sort()
for i in ls:
    print(i.rstrip())