n = int(input())

for i in range(n):
    r, s = input().split()
    p = ""
    for c in s:
        p += c * int(r)
    print(p)