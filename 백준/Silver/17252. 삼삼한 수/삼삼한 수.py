import sys

input = sys.stdin.readline

N = int(input())
if N ==0:
    print("NO")
else:
    while N > 0:
	    if N % 3 ==0:
		    N //=3
	    else:
		    N -= 1
		    if N % 3==0:
			    N //= 3
		    else:
			    print("NO")
			    break
    else:
	    print("YES")