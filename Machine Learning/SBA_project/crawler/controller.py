import sys
sys.path.insert(0, 'E:/Dropbox/Dropbox/Programming/Git/Machine Learning/SBA_project')
# from crawler.entity import Entity
from crawler.service import Service

class Controller:
    def __init__(self):
        pass

if __name__ == '__main__':
    api = Controller()
    service = Service()
    # url 파싱
    soup = service.naver_cartoon('https://comic.naver.com/webtoon/weekday.nhn')
    
    myfolder = 'E:/Dropbox/Dropbox/Programming/Git/Machine Learning/SBA_project/crawler/webtoon_data/'
    
    # 요일별 폴더 생성
    weekday_dict = service.create_folder_weekend(myfolder)

    # 웹툰 리스트 추출 및 저장
    mylist = service.create_webtoon_list(soup, myfolder, weekday_dict)

    service.save_csv_file(mylist, 'naver_webtoon_list')

    print(type(mylist))
    # for item in mylist:
    #     print(item)





