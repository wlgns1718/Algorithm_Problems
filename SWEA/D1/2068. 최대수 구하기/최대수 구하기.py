T = int(input())
 
for test_case in range(1, T + 1):
    b= set()
    a = list(map(int, input().split()))
    b.update(a)
    print("#{0} {1}".format(test_case, max(b)))