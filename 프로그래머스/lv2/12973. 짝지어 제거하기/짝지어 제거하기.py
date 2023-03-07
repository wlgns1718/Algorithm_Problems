def solution(s):
    answer = -1
    temp = []
    for i in s:
        temp.append(i)
        if len(temp) > 1:
            if temp[-1]==temp[-2]:
                del temp [-2:]
    if len(temp) == 0:
        answer = 1
    else:
        answer = 0
    return answer