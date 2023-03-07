import heapq
def solution(jobs):
    answer = 0
    heap = []
    cur = 0
    l = len(jobs)
    jobs.sort(key=lambda x:x[0])
    while jobs or heap:
        while jobs and jobs[0][0] <= cur: #실행할 수 있는 모든 프로그램 담기
            temp = jobs.pop(0)
            heapq.heappush(heap,(temp[1],temp[0])) #힙에 걸리는 시간이 빠른 것부터 정렬
        if heap:
            cur_program = heapq.heappop(heap)
            cur += cur_program[0]
            answer += (cur-cur_program[1])
            
        else:
            cur += 1
    
    return (answer//l)