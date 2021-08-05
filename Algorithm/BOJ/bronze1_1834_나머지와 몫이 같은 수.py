
n = int(input())

arr = []
i = 1
while True:
    q, r = divmod(i, n)
    if q == r:
        arr.append(i)
    elif q == n:
        break
    i+= 1
print(sum(arr))