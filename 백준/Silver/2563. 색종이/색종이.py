import sys
a = [[0] * 100 for _ in range(100)]


def paint(w, h):
    for i in range(w, w + 10):
        for j in range(h, h + 10):
            a[i][j] = 1


n = int(sys.stdin.readline())
for i in range(n):
    w, h = map(int, sys.stdin.readline().split())
    paint(w, h)

count = 0
for i in range(100):
    for j in range(100):
        if a[i][j] == 1:
            count += 1
print(count)