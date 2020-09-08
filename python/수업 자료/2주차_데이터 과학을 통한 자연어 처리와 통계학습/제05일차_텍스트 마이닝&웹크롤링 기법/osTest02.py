# osTest02.py
# os 모듈: Operating System(운영체제)와 관련된 모듈
# 폴더/파일 생성, 수정, 삭제 등등
# 파일과 관련된 여러 속성 정보

import os

# 폴더 구분자 사용할 때 슬래시는 한 번만, 역슬래시는 반드시 두 개를 적어야 함
myfolder = 'd:\\'
newpath = os.path.join(myfolder, 'sample') # 경로 병합

try:
    # os.mkdir(path=newpath) # 폴더 생성

    for idx in range(1, 11):
        # zero fill
        newfile = os.path.join(newpath, 'folder' + str(idx).zfill(2))
        os.mkdir(path=newfile)

except FileExistsError as err:
    print('폴더가 이미 존재합니다')
    print(err)

print('finished')
