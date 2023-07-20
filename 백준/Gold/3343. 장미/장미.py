import sys
import math
input = sys.stdin.readline

N, A, B, C, D = map(int,input().split())
#A개를 B원에 C개를 D원
if B*C < D*A:
    A, B, C, D = C, D, A, B

#첫 번째 가게가 더 가성비가 좋다
answer = float("INF")

#A개를 C만큼 사는게 더 이득 => C를 A개보다 많이 사면 손해
for i in range(C):
    #C를 i개 만큼 사기
    temp = math.ceil((N - i * A)/C)
    tri = False
    if temp < 0:
        temp = 0
        tri = True
    answer = min(answer, temp * D + i * B)
    if tri:
        break
print(answer)