import sys

input = sys.stdin.readline

def preorder(string):
    global answer
    for i in tree:
        if i[0] == string:
            for j in i[1:]:
                if j == ".":
                    continue
                answer += j
                preorder(j)

def inorder(string):
    global answer

    for i in tree:
        if i[0] == string:
            for idx,j in enumerate(i[1:]):
                if i[0] == string and idx == 1:
                    answer += string
                if j == ".":
                    continue
                inorder(j)
def postorder(string):
    global answer

    for i in tree:
        if i[0] == string:
            for j in i[1:]:
                if j == ".":
                    continue
                postorder(j)
            answer += string



N = int(input())

tree = [list(map(str,input().split())) for _ in range(N)]
answer = "A"
preorder("A")
print(answer)

answer = ""
inorder("A")
print(answer)

answer = ""
postorder("A")
print(answer)