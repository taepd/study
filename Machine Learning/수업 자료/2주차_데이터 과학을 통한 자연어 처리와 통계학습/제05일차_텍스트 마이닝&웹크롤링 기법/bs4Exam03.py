# bs4Exam03.py
import urllib.request

from bs4 import BeautifulSoup
from pandas import DataFrame

url = "http://movie.naver.com/movie/sdb/rank/rmovie.nhn"
html = urllib.request.urlopen(url)
soup = BeautifulSoup(html, 'html.parser')
print(type(soup))

tags = soup.findAll('div', attrs={'class': 'tit3'}) # findAll과 find_all은 동일. 전자는 bs의 올드스타일 레거시
print(tags)
print('-'*30)

for tag in tags:
    print(tag.a.string) # 해당 태그의 하위를 찾아가는 방법
print('-'*30)

print('<a> 태그의 href 전체 태그')
url_header = 'http://movie.naver.com'
for tag in tags:
    print(url_header + tag.a['href'])
print('-'*30)

mytrs = soup.find_all('tr')
print(len(mytrs))

no = 0  # 순서를 의미하는 번호
totallist = []  # 전체를 저장할 리스트

for one_tr in mytrs:
    # print(one_tr)
    # print('@'*30)

    title = ''
    up_down = '' # 순위 변동 설명 문구

    mytd = one_tr.find('td', attrs={'class': 'title'})
    if mytd is not None:
        no += 1
        newno = str(no).zfill(2)

        mytag = mytd.find('div', attrs={'class': 'tit3'})
        title = mytag.a['title'] # title 속성에도 위의 a.string과 마찬가지로 제목이 담겨있다

        # 순위 변동 부분 파싱
        mytd = one_tr.select_one('td:nth-of-type(3)')  # 세 번째 td를 선택
        myimg = mytd.find('img')
        if myimg.attrs['alt'] == 'up':
            up_down = '상승'
        elif myimg.attrs['alt'] == 'down':
            up_down = '강등'
        else:
            up_down = '불변'

        change = one_tr.find('td', attrs={'class': 'range ac'})
        if change is None:
            change = '신규 진입'
        else:
            change = change.string

        # print(newno + '/' + title + '/' + up_down + '/' + change)

        # csv로 저장
        totallist.append((newno, title, up_down, change))

mycolumns = ['순위', '제목', '변동', '변동폭']
myframe = DataFrame(totallist, columns=mycolumns)

filename = 'naverMovieRank.csv'

myframe.to_csv(filename)

print(filename + ' 파일 저장됨')
print('-'*30)












