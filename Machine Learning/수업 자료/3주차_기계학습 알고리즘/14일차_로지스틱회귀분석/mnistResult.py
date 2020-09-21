# mnistResult.py
import matplotlib.pyplot as plt

plt.rc('font', family='Malgun Gothic')
mylist = []

test_acc = [0.9235, 0.9234, 0.9764, 0.9754, 0.9746]
test_loss = [0.2795, 0.2781, 0.0817, 0.1232, 0.0974]
comments = ['테스트01', '테스트02', '테스트03', '테스트04', '테스트05']

mycolor = ['b', 'g', 'r', 'c', 'b']

plt.title('테스트 케이스별 정확도')
plt.xlabel('테스트 케이스')
plt.ylabel('정확도')
plt.bar(comments, test_acc, color=mycolor)

filename = 'mnist_accuracy_graph.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

plt.figure()
plt.title('테스트 케이스별 비용')
plt.xlabel('테스트 케이스')
plt.ylabel('비용')
plt.bar(comments, test_loss, color=mycolor)

filename = 'mnist_loss_graph.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

print('finished')
