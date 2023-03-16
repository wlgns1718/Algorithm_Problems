def solution(n,a,b):
    import math
    answer = 0
    if a> b:
        a, b = b, a
    while True:
        answer += 1
        a = math.ceil(a/2)
        b = math.ceil(b/2)
        n = math.ceil(n/2)
        if a-b ==0 :
            break
        elif (b-a == 1 and a%2==1) or n<2:
            answer += 1
            break
        

    return answer