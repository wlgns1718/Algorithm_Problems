import sys

input = sys.stdin.readline

T = int(input())
map_graph = [0]*1100
x_list = []
y_list = []
for i in range(T):
    L, H = map(int,input().split())
    map_graph[L] = H
    x_list.append(L)
    y_list.append(H)

x_max = max(x_list)
max_height = max(y_list)
temp = 0
answer = 0
left_x, right_x = 0,0
for i in range(0,x_max+1):
    if(map_graph[i] == max_height):
        left_x = i
        break
    temp = max(temp,map_graph[i])
    answer += temp
temp = 0
for i in range(x_max+1,-1,-1):
    if(map_graph[i] == max_height):
        right_x = i
        break
    temp = max(temp, map_graph[i])
    answer += temp
if (right_x == left_x):
    answer += max_height
else:
    answer += (right_x-left_x+1)*max_height
print(answer)