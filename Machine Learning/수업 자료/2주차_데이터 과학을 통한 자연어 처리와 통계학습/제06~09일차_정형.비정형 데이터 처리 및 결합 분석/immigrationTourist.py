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


def getNatVisitor(yyyymm, nat_cd, ed_cd):
    end_point = 'http://openapi.tour.go.kr/openapi/service'
    end_point += '/EdrcntTourismStatsService'
    end_point += '/getEdrcntTourismStatsList'

    parameters = '?'
    parameters += '_type=json'
    parameters += '&serviceKey=' + access_key
    parameters += '&YM=' + yyyymm  # 년월
    parameters += '&NAT_CD=' + nat_cd  # 국가코드
    parameters += '&ED_CD=' + ed_cd  # 출국/입국

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

    for year in range(nStartYear, nEndYear+1):
        for month in range(1, 13):
            yyyymm = '%s%s' % (str(year), str(month).zfill(2))

            jsonData = getNatVisitor(yyyymm, national_code, ed_cd)
            # print(jsonData)

            if jsonData['response']['header']['resultMsg'] == 'OK':
                # krName = jsonData['response']['body']['items']['item']['natKorNm']
                # krName = krName.replace(' ', '')

                totalCount = jsonData['response']['body']['totalCount']
                if totalCount != 0:

                    iTotalVisit = jsonData['response']['body']['items']['item']['num']
                    # print('%s_%s : %s' % (krName, yyyymm, iTotalVisit))

                    jsonResult.append({'nat_name': nation, 'nat_cd': national_code, 'yyyymm': yyyymm, 'visit_cnt': iTotalVisit})

            # break # 차후 삭제 예정
        # end inner for
        # break # 차후 삭제 예정
    # end outer for

    # 파일 저장하기
    savedFilename = 'immigrationTourist %s(%s)_(%d~%d).json'
    filename = savedFilename % (nation, national_code, nStartYear, nEndYear)

    with open(filename, 'w', encoding='utf-8') as outfile :
        retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
        outfile.write((retJson))
    print(filename + '파일 저장됨')

    # 그래프 그리기
    cnVisit = []  # 방문자수
    visitYM = []  # 방문한 년월
    index = []
    i = 0

    for item in jsonResult:
        index.append(i)
        cnVisit.append(item['visit_cnt'])
        visitYM.append(item['yyyymm'])
        i += 1

    plt.xticks(index, visitYM)  # x축 그려지는 작은 눈금
    plt.plot(index, cnVisit)  # plot 그려주는 역할
    plt.xlabel('방문월')  # x축 레이블
    plt.ylabel('방문객수')  # y축 레이블
    plt.show()  # 시각화를 보여주는 함수


#  파일이 실행되면 main 함수 호출
if __name__ == '__main__':
    main()
