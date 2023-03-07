n = int(input())
for _ in range(n):
    number = int(input())
    for i in range(2,1000000+1):
        if number % i == 0:
            print("NO")
            break
    else:
        print("YES")