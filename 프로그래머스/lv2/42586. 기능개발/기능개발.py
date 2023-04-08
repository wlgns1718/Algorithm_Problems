def solution(progresses, speeds):
    answer = []
    while len(progresses) > 0 :
        temp = []
        if progresses[0] == 100:
            for _ in range(len(progresses)):
                if progresses[0] == 100 :
                    temp.append(progresses.pop(0))
                    speeds.pop(0)
                else:
                    break
        else:
            for i in range(len(progresses)):
                progresses[i] += speeds[i]
                if progresses[i] > 100:
                    progresses[i] = 100
        if len(temp)>0:
            answer.append(len(temp))
        
    return answer