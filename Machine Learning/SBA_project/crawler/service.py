from bs4 import BeautifulSoup
from urllib.request import urlopen
from pandas import DataFrame
import os, shutil

class Service:
    def __init__(self):
        pass

    def bugs_music(self):
        pass

    def naver_movie(self):
        pass


    def naver_cartoon(self, url):
        myparser = 'html.parser' # html.parser : 간단한 HTML과 XHTML 구문 분석기. 표준 라이브러리
        response = urlopen(url)
        soup = BeautifulSoup(response, myparser)
        print(type(soup))
        # print(soup)
        return soup

    # 요일별 폴더 생성
    def create_folder_weekend(self, myfolder):
        weekday_dict = {'mon': '월요일', 'tue': '화요일', 'wed': '수요일', 'thu': '목요일', 'fri': '금요일', 'sat': '토요일', 'sun': '일요일'}

        # shutil : shell utility : 고수준 파일 연산. 표준 라이브러리
       
        # myfolder = 'E:/Dropbox/Dropbox/Programming/Git/Machine Learning/SBA_project/crawler/webtoon_data/' # 유닉스 기반은 '/'이 구분자
        self.myfolder = myfolder
        try:
            if not os.path.exists(myfolder):
                os.mkdir(myfolder)

            for mydir in weekday_dict.values():
                mypath = myfolder + mydir

                if os.path.exists(mypath):
                    # rmtree : remove tree
                    shutil.rmtree(mypath)

                os.mkdir(mypath)

        except FileExistsError as err:
            print(err)
        
        return weekday_dict
   
   
    # # 각 이미지를 저장해주는 함수
    # def save_img_file(self, mysrc, myweekday, mytitle):
    #     image_file = urlopen(mysrc)
    #     filename = myfolder + weekday_dict[myweekday] + '\\' + mytitle + '.jpg'
    #     # print(mysrc)
    #     # print(filename)

    #     myfile = open(filename, mode='wb') # wb : write binary
    #     myfile.write(image_file.read()) # 바이트 형태로 저장
    #     myfile.close()

    # 웹툰 리스트 추출 함수
    def create_webtoon_list(self, soup, myfolder, weekday_dict):
        mytarget = soup.find_all('div', attrs={'class': 'thumb'})
        print(len(mytarget))

        mylist = []  # 데이터를 저장할 리스트

        for abcd in mytarget:
            myhref = abcd.find('a').attrs['href']
            myhref = myhref.replace('/webtoon/list.nhn?', '')
            result = myhref.split('&')
            # print(myhref)
            # print(result)
            mytitleid = result[0].split('=')[1]
            myweekday = result[1].split('=')[1]
            # print(mytitleid)
            # print(myweekday)

            imgtag = abcd.find('img')
            mytitle = imgtag.attrs['title'].strip()
            mytitle = mytitle.replace('?','').replace(':','')
            # print(mytitle)

            mysrc = imgtag.attrs['src']
            # print(mysrc)

            image_file = urlopen(mysrc)
            filename = myfolder + weekday_dict[myweekday] + '\\' + mytitle + '.jpg'
            # print(mysrc)
            # print(filename)

            myfile = open(filename, mode='wb') # wb : write binary
            myfile.write(image_file.read()) # 바이트 형태로 저장
            myfile.close()

            sublist = []
            sublist.append(mytitleid)
            sublist.append(myweekday)
            sublist.append(mytitle)
            sublist.append(mysrc)
            mylist.append(sublist)
        
        return mylist



    # csv파일로 저장
    def save_csv_file(self, mylist, filename):
        mycolumns = ['타이틀 번호', '요일', '제목', '링크']
        myframe = DataFrame(mylist, columns=mycolumns)

        self.filename = filename

        myframe.to_csv(filename, encoding='utf-8', index=False)
        print(filename + '파일로 저장됨')


