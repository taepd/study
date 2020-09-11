# immigrationTourist.py
# 출입국 관관 통계 서비스
import urllib.parse
import urllib.request
import json
import matplotlib.pyplot as plt

# 그래프 한글 깨짐 방지
plt.rc('font', family='Malgun Gothic')
# 맥북은 AppleGothic 넣으면 됨


def getRequestUrl(url):  # 해당 url 문자열을 이용하여 정보를 읽어 옴
    req = urllib.request.Request(url)
    try:
        res = urllib.request.urlopen(req)
        if res.getcode() == 200:  # 문제 없음
            # print('발생 시각 : [%s]' % (datetime.datetime.now()))
            # print('url 정보 : [%s]' % (url))
            return res.read().decode('utf-8')
    except Exception as err:
        # print(err)
        # print('발생 시각 : [%s]' % (datetime.datetime.now()))
        print('오류 발생 url : [%s]' % (url))
        return None


access_key = 'ert%2FZfJtkj89cCSi5ZSE9%2F92EbX6GBNmvblp%2FvbAew%2FLowvWjzIo5zpRxBK%2BzmOsXGLeJK7qE1khwg3DtnE4QA%3D%3D'


def getCorona19Data(startCreateDt, endCreateDt):
    end_point = 'http://openapi.data.go.kr/openapi/service/rest/Covid19'
    end_point += '/getCovid19InfStateJson'

    parameters = '?'
    parameters += '_type=json'
    parameters += '&serviceKey=' + access_key
    parameters += '&startCreateDt=' + startCreateDt  # 데이터 생성일 시작범위
    parameters += '&endCreateDt=' + endCreateDt  # 데이터 생성일 종료범위


    url = end_point + parameters

    retData = getRequestUrl(url)

    if retData is None:
        return None
    else:
        return json.loads(retData)


def main():
    jsonResult = []

    # 중국 : 112, 일본 : 130, 미국 : 275
    nation = '중국'
    national_code = '112'
    ed_cd = 'E' # 방한한 외래 관광객

    nStartYear = 2015
    nEndYear = 2020
    startCreateDt = 20200101
    endCreateDt = 20200831

    # for year in range(nStartYear, nEndYear+1):
    #     for month in range(1, 13):
    #         yyyymm = '%s%s' % (str(year), str(month).zfill(2))

    jsonData = getCorona19Data(str(startCreateDt), str(endCreateDt))
    print(type(jsonData['response']['body']['items']['item']))

    if jsonData['response']['header']['resultMsg'] == 'NORMAL SERVICE.':
        # krName = jsonData['response']['body']['items']['item']['natKorNm']
        # krName = krName.replace(' ', '')
        print('ok')

        totalCount = jsonData['response']['body']['totalCount']

        if totalCount != 0:
            data = jsonData['response']['body']['items']['item']

            for i in range(len(data)):
                # print(data[i])
                stateDt = data[i]['stateDt']
                decideCnt = data[i]['decideCnt']

                jsonResult.append({'stateDt': stateDt, 'decideCnt': decideCnt})
        # 날짜 역순으로 나와서 배열 역전
        jsonResult = list(reversed(jsonResult))

        print(jsonResult)

            # break # 차후 삭제 예정
        # end inner for
        # break # 차후 삭제 예정
    # end outer for

    # 파일 저장하기
    savedFilename = 'coronaStatus(%d~%d).json'
    filename = savedFilename % (startCreateDt, endCreateDt)

    with open(filename, 'w', encoding='utf-8') as outfile :
        retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
        outfile.write((retJson))
    print(filename + '파일 저장됨')

    # 그래프 그리기
    stateDt = []  # 기준 일자
    decideCnt = []  # 확진자 수
    index = []
    i = 0

    for item in jsonResult:
        index.append(i)
        stateDt.append(item['stateDt'])
        decideCnt.append(item['decideCnt'])
        i += 1

    plt.xticks(index, stateDt)  # x축 그려지는 작은 눈금
    plt.plot(index, decideCnt)  # plot 그려주는 역할
    plt.xlabel('기준 일자')  # x축 레이블
    plt.ylabel('확진자 수')  # y축 레이블
    plt.show()  # 시각화를 보여주는 함수


#  파일이 실행되면 main 함수 호출
if __name__ == '__main__':
    main()
