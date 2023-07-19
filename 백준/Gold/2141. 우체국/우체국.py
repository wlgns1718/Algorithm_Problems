import sys

input = sys.stdin.readline

N = int(input())
all_people = 0
people = []
ls = []
for _ in range(N):
    a,b = map(int,input().split())
    ls.append([a,b])
ls.sort(key=lambda x: x[0])
for i in ls:
    if not people:
        people.append(i[1])
        all_people += i[1]
        continue
    people.append(people[-1] + i[1])
    all_people += i[1]
start = 0
end = N - 1
mid = 0
all_people /= 2
while start <= end:
    mid = (start+end)//2

    if people[mid] < all_people:
        start = mid + 1
    else:
        end = mid - 1
print(ls[start][0])