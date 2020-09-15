# word2vec_model_test.py
# 이전에 만들어 둔 모델 파일을 읽어 와서 특정 단어와 유사한 단어들을 찾아 봅니다.
# 인접한 유사도를 이용하여 데이터를 시각화 해 봅니다.
from gensim.models import word2vec
import  matplotlib.pyplot as plt

plt.rc('font', family='Malgun Gothic')

def showGraph(bar_graph):
    length = len(bar_graph)  # 요소 갯수
    # x축에 보이는 글자
    myticks = list(mydata[0] for mydata in bar_graph)
    # 그려질 수치 데이터
    chart_data = list(mydata[1] for mydata in bar_graph)
    my_color = ['b', 'g', 'r', 'c', 'm', 'y', 'k', '#56FFCC', '#00CCFF', '#CCDDEE']

    plt.figure()
    plt.barh(myticks, chart_data, color=my_color, align='center')
    plt.yticks(range(length), myticks, rotation='10')
    plt.xlim(min(chart_data) - 0.02, max(chart_data) + 0.02)
    filename = 'word2vec_model_01.png'
    plt.savefig(filename)
    print(filename + ' 파일 저장됨')

def makePie(pie_graph):
    # x축에 보이는 글자
    myticks = list(mydata[0] for mydata in pie_graph)
    # 그려질 수치 데이터
    chart_data = list(mydata[1] for mydata in pie_graph)
    my_color = ['b', 'g', 'r', 'c', 'm']

    plt.figure()
    plt.pie(chart_data, colors=my_color, labels=myticks, startangle=90, shadow=False,
            explode=(0, 0.05, 0, 0, 0), autopct='%1.2f%%', normalize=True)
    filename = 'word2vec_model_02.png'
    plt.savefig(filename)
    print(filename + ' 파일 저장됨')

model_file = 'word2vec.model'

model = word2vec.Word2Vec.load(model_file)
print(type(model))


# most_similar : positive에 명시된 단어에 대하여 유사도가 높은 항목 리턴
# topn: 상위 n개 노출
bar_graph = model.wv.most_similar(positive=['국민'], topn=10)
print(bar_graph)

pie_graph = model.wv.most_similar(positive=['남북'], topn=5)
print(pie_graph)

showGraph(bar_graph)

makePie(pie_graph)

print('finished')