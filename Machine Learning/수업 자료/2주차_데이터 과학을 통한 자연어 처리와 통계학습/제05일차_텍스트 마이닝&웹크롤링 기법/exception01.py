# exception01.py
"""
예외 처리 : 예외가 발생하지 않도록 사전에 막음 조치를 취하는 것

예외 처리 방법
try:
    일반적인 코드 작성
except 예외클래스 이름 [as 예외별칭]:
    적당한 오류 메시지 보여주기
else:
    예외가 없을 때 하고자 하는 내용 기록
finally:
    예외 발생 여부와 상관없이 하고자 하는 내용 기록
    주로 마감 작업(파일 닫기, 데이터베이스 접속 종료 등)
"""

try:
    x = 4
    y = 0

    mydict = {'a':10}

    print(mydict['b'])

    mylist = [1, 2, 3]
    print((mylist[4]))  # IndexError: list index out of range

    z = x / y  # ZeroDivisionError

except ZeroDivisionError as err:
    # err이란 이름은 임의의 이름이여도 됨
    print('0으로 나누면 안됩니다.')
    print(err)

except IndexError as err:
    print('인덱스 범위 관련 오류 발생')
    print(err)

except KeyError as err:
    print('딕셔너리 없는 키 호출')
    print(err)

else:
    print('예외가 없으면 이 라인이 실행됩니다.')

finally:
    print('예외 발생 여부 상관없이 무조건 실행됩니다')

