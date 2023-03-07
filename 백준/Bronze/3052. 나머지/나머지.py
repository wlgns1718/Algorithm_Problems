import sys

input = sys.stdin.readline
nums = []
for _ in range(10):
    nums.append(int(input()))
visit = set()
for i in nums:
    visit.add(i%42)
print(len(visit))