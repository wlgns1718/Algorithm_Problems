def solution(triangle):
    answer = 0
    for i in range(1,len(triangle)):
        cur_line = triangle[i]
        pre_line = triangle[i-1]
        for j in range(len(cur_line)):
            if j == 0:
                triangle[i][j] += pre_line[0]
                
            elif j == (len(cur_line)-1):
                triangle[i][j] += pre_line[-1]
            
            else:
                triangle[i][j] += max(pre_line[j-1],pre_line[j])
            
            
    answer = max(triangle[-1])        
    return answer