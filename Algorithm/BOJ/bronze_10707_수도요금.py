a = int(input())
b = int(input())
c = int(input())
d = int(input())
p = int(input())

print(min(a*p, b*(min(p,c)) + d*(max(0,p-c))))