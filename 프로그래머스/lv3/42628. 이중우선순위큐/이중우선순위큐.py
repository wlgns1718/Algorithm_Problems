import heapq
def solution(operations):
    answer = []
    heap = []
    heap_max = []
    for i in operations:
        op = i[0]
        if op == "I":#푸쉬
            num = int(i[2:])
            heapq.heappush(heap,num)
            heapq.heappush(heap_max,(-num,num))

        else:
            if not heap:
                continue
            else:
                op = i[2:]
                if op =='-1': #최솟값 삭제
                    temp = heapq.heappop(heap)
                    heap_max.remove((-temp,temp))
                else:
                    temp = heapq.heappop(heap_max)[1]
                    heap.remove(temp)
    if heap:
        answer=[heapq.heappop(heap_max)[1],heapq.heappop(heap)]
    else:
        answer = [0,0]
    return answer