# correlationAnalysis.py
import numpy as np
import matplotlib.pyplot as plt
import os
import json
import pandas as pd

plt.rc('font', family='Malgun Gothic')

corr_list = []  # 상관 관계 분석 결과 저장
my_chart = './my_chart/'  # 그래프가 생성될 폴더


def correlation(x, y):  # 상관 계수를 구해주는 함수 (피어슨 상관 계수)
    bar_x = x.mean()
    bar_y = y.mean()

    bunja = np.sum((x-bar_x)*(y-bar_y))
    # print(f'분자 : {bunja}')

    left = np.sum((x-bar_x)**2)
    right = np.sum((y-bar_y)**2)
    bunmo = np.sqrt(left*right)
    # print(f'분모 : {bunmo}')

    return bunja / bunmo


def setScatterGraph(tour_table, visit_table, tour_point):
    # tour_table : 관광지 입장 정보
    # visit_table : 3개국 관광객 수
    # tour_point : 관광지 이름(예시: 경복궁)
    tour = tour_table[tour_table['resNm'] == tour_point]
    merge_table = pd.merge(tour, visit_table, left_index=True, right_index=True)
    # print('#'*30)
    # print(merge_table)

    mylist = [['china', '중국인'], ['usa', '미국인'], ['japan', '일본인']]
    tmp = []
    tmp.append(tour_point)  # 방문지를 추가

    fig = plt.figure() # 새 도화지를 준비

    print(f'[{tour_point}] 작업 중입니다')
    for onedata in mylist:
        plt.xlabel(onedata[1] + '입국 수')  # 예시) 중국인 입국 수
        plt.ylabel('외국인 입장객수')

        # 해당 국가의 컬럼만 추출
        x_data = list(merge_table[onedata[0]])
        y_data = list(merge_table['ForNum'])

        cor = correlation(np.array(x_data), np.array(y_data))
        cor = round(cor, 6)

        if cor == 0:
            print('상관 계수가 0입니다.')
            return

        # plt.title(tour_point + '-' + onedata[1] + '상관 관계 분석(' + str(cor) + ')')
        plt.title(f'{tour_point} - {onedata[1]} 상관 관계 분석({str(cor)})')
        plt.scatter(x_data, y_data, edgecolors='none', alpha=0.75, s=6, c='black')

        # savefig() : 해당 이미지를 파일 형식으로 저장하는 함수
        plt.savefig(my_chart + tour_point + '(' + onedata[1] + ').png')

        mytuple = (onedata[1], cor)  # ('중국인', 0.123456)
        tmp.append(mytuple)  #  ['창덕궁', ('중국인', 0.123456)]

    corr_list.append(tmp)

# end def setScatterGraph


def main():
    if not os.path.exists(my_chart):
        os.mkdir(my_chart)

    filename = './data/touristResourceStat(서울특별시 2015~2019).json'
    # read(): json 스트링화, loads: json 리스트화(리스트 안 딕셔너리 형태)
    jsonTP = json.loads(open(filename, 'rt', encoding='utf-8').read())
    # print(type(jsonTP))
    # print(jsonTP)
    # pandas를 이용해 DataFrame화
    tour_table = pd.DataFrame(jsonTP, columns=('yyyymm', 'resNm', 'ForNum'))
    # print(type(tour_table))
    # print(tour_table.head())  # 전체 데이터 중에서 앞 5개만 출력

    # 'yyymm' 컬럼을 인덱스로 지정(set_index())
    tour_table = tour_table.set_index('yyyymm')
    print(tour_table.head())

    #################################################################
    # 미국 방문자 테이블
    filename = './data/immigrationTouristStat 미국(275)_(2015~2019).json'
    jsonTP = json.loads(open(filename, 'rt', encoding='utf-8').read())
    usa_table = pd.DataFrame(jsonTP, columns=('yyyymm', 'visit_cnt'))
    # 'yyyymm' 컬럼을 색인으로 지정
    usa_table = usa_table.set_index('yyyymm')
    # 'visit_cnt' 컬럼을 국가 이름으로 변경
    usa_table = usa_table.rename(columns={'visit_cnt': 'usa'})

    print(usa_table.head())

    # 일본 방문자 테이블
    filename = './data/immigrationTouristStat 일본(130)_(2015~2019).json'
    jsonTP = json.loads(open(filename, 'rt', encoding='utf-8').read())
    japan_table = pd.DataFrame(jsonTP, columns=('yyyymm', 'visit_cnt'))
    # 'yyyymm' 컬럼을 색인으로 지정
    japan_table = japan_table.set_index('yyyymm')
    # 'visit_cnt' 컬럼을 국가 이름으로 변경
    japan_table = japan_table.rename(columns={'visit_cnt': 'japan'})

    print(japan_table.head())


    # 중국 방문자 테이블
    filename = './data/immigrationTouristStat 중국(112)_(2015~2019).json'
    jsonTP = json.loads(open(filename, 'rt', encoding='utf-8').read())
    china_table = pd.DataFrame(jsonTP, columns=('yyyymm', 'visit_cnt'))
    # 'yyyymm' 컬럼을 색인으로 지정
    china_table = china_table.set_index('yyyymm')
    # 'visit_cnt' 컬럼을 국가 이름으로 변경
    china_table = china_table.rename(columns={'visit_cnt': 'china'})

    print(china_table.head())

    # merge : 2개의 데이터 프레임을 합쳐주는 기능
    fv_table = pd.merge(china_table, japan_table, left_index=True, right_index=True)
    fv_table = pd.merge(fv_table, usa_table, left_index=True, right_index=True)

    print(fv_table.head())

    #resNm : 방문지(목록)
    resNm = tour_table.resNm.unique()
    print(resNm)
    for tour_point in resNm:
        setScatterGraph(tour_table, fv_table, tour_point)
        # break  # 차후 삭제 예정

    print('-'*30)
    print(corr_list)


if __name__ == '__main__':
    main()