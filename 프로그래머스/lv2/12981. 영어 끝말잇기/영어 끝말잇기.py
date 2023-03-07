import math
def solution(n, words):
    answer = []
    remember = []
    who = times = 0
    for i in words:
        if len(remember)==0:
            remember.append(i)
            continue
        if remember[-1][-1] != i[0]:
            who = len(remember)%n+1
            times = math.ceil((len(remember)+1)/n)
            break
        else:
            if i not in remember:
                remember.append(i)
            else:
                who = len(remember)%n+1
                times = math.ceil((len(remember)+1)/n)
                break
    answer = [who,times]        
    return answer