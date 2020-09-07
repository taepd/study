mylist = list(map(int, input().split(';')))
mylist.sort(reverse=True)
for i in mylist:
    print('{0:>9,}'.format(i))

