import sys
input = sys.stdin.readline

def sol(start,time):
    total = 0
    #무조건 정액제가 유리한 경우 남은 시간과 분이 5시간보다 크거나 같을 때 현재 시각이 10시에서 3시 사이인 경우
    while time > 0:
        if time >= 300 and (22 <= start[0] <= 23 or 0 <= start[0] <= 2 or (start[1]==0 and start[0]==3)):
            total += 5000
            while start[0] != 8:
                if time <= 0:
                    return total
                if start[0] == 7 and start[1] != 0:
                    temp = 60 - start[1]
                    start[1] = 0
                    time -= temp
                    break
                start[0] += 1
                if start[0] == 24:
                    start[0] = 0
                time -= 60
        else:
            start[0] += 1
            time -= 60
            total += 1000
    return total


N = int(input())
for _ in range(N):
    a, b = map(str,input().split())

    hour, minute = a.split(":")
    #22시부터 8시까지(10시부터 3시까지면 5천원, 3시부터 8시 까지 5천원)
    start_time = [int(hour),int(minute)]

    print(sol(start_time,int(b)))