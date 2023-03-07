a = input()
b = input()
b_list = [int(i) for i in str(b)]
val = []
res = 0
for i in range(len(b_list)):
    val.append((b_list[i]*int(a)))
val.reverse()
for i in range(len(val)):
    print(val[i])
    if (i+1) == len(val):
        for i in range(len(val)):
            res += val[i] * (10**i)
        print(res)