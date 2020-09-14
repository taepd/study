# tojiFrequency.py
# 참조 파일 : tojiText.txt, stopword.txt, alice_color.png
# 토지 파일을 읽어 들여서 워드 클라우드와 막대 그래프 그리기
import numpy as np
from PIL import Image  # pillow 설치 요망
from wordcloud import WordCloud  # 참고 : pytagcloud 도 있음(강사님 비추천)
from wordcloud import ImageColorGenerator
import matplotlib.pyplot as plt

plt.rc('font', family='Malgun Gothic')

class Visualization:
    def __init__(self, word_list):
        self.word_list = word_list
        # dict 형식으로 변경
        self.word_dict = dict(self.word_list)

    def make_word_cloud(self):  # 워드 클라우드
        alice_color_file = '../첨부(2주차)/alice_color.png'
        # 이미지를 넘파이 배열로 바꿈
        alice_coloring = np.array(Image.open(alice_color_file))

        font_path = 'malgun.ttf'
        word_cloud = WordCloud(font_path=font_path, mask=alice_coloring,
                               relative_scaling=0.2, background_color='lightyellow')
        word_cloud = word_cloud.generate_from_frequencies(self.word_dict)

        image_colors = ImageColorGenerator(alice_coloring)
        new_wc = word_cloud.recolor(color_func=image_colors, random_state=42)

        plt.imshow(new_wc)
        plt.axis('off')

        filename = 'toji_world_cloud.png'
        plt.savefig(filename)
        plt.figure(figsize=(16, 8))

    def make_bar_chart(self):  # 막대 그래프
        # result를 이용하여 막대 그래프를 그려 보세요
        result = self.word_list[0:10]  # 10개 데이터
        # print('result', result)
        length = len(result)  # 요소 갯수
        # x축에 보이는 글자
        myticks = list(mydata[0] for mydata in result)
        # 그려질 수치 데이터
        chart_data = list(mydata[1] for mydata in result)
        my_color = ['b', 'g', 'r', 'c', 'm', 'y', 'k', '#56FFCC', '#00CCFF', '#CCDDEE']

        plt.figure()
        plt.title(f'토지 상위 {length}개 키워드 빈도수')
        plt.bar(myticks, chart_data, color=my_color, align='center')
        plt.xticks(range(length), myticks, rotation='10')
        plt.ylim(0, max(chart_data) + 0.02)
        plt.xlabel('주요 키워드')
        plt.ylabel('빈도수')
        filename = 'toji_bar_chart.png'
        plt.savefig(filename, dpi=400, bbox_inches='tight')
        print(filename + ' 파일 저장됨')


filename = '../첨부(2주차)/tojiText.txt'
ko_con_text = open(filename, 'rt', encoding='utf-8').read()

from konlpy.tag import Okt

okt = Okt()
token_ko = okt.nouns(ko_con_text) # 분석할 단어들

# 불용어(stopword) : 빈도수에 상관없이 분석에서 배제할 단어
stop_word_file = '../첨부(2주차)/stopword.txt'
# \ufeff 에러 : encoding을 utf-8-sig로
stop_file = open(stop_word_file, 'rt', encoding='utf-8-sig')
stop_words = [word.strip() for word in stop_file.readlines()]

# print(stop_words)

token_ko = [each_word for each_word in token_ko if each_word not in stop_words]


# nltk : national language toolkit
import nltk

# token : 작은 절편
ko = nltk.Text(tokens=token_ko)

# 가장 빈도수가 많은 500개만 추출
data = ko.vocab().most_common(500)
# print(data)

word_list = list()  # 튜플(단어, 빈도수)를 저장할 리스트
for word, count in data:
    if count >= 50 and len(word) >= 2:
        word_list.append((word, count))

visual = Visualization(word_list)
visual.make_word_cloud()
visual.make_bar_chart()


print('finished')