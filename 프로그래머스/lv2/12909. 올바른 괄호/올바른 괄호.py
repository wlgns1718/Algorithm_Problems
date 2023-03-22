def solution(s):
    answer = True
    ls = list(s)
    sol=[]
    cnt = 0
    for i in ls:
        if i =='(':
            sol.append(i)
        else:
            if len(sol) !=0:
                sol.pop()
            else:
                answer = False
                cnt = 1
                break
                
    if len(sol) == 0 and cnt != 1:
        answer = True
    else:
        answer = False

    return answer