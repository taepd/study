# getUrl.py
# 네이버 사이트의 url 정보 취득

# client-server 환경
import urllib.request

url = 'http://www.naver.com'

# 파라미터 추가
# ?는 url과 parameter의 구분자 역할
# =는 parameter 이름과 값의 구분자 역할
# &는 parameter 간 구분자 역할
parameter ='?'
parameter += 'id=asdf'
parameter += '&password=1234'
parameter += '&message=hahaha'

url += parameter

print(url)

# request : 요청 객체
request = urllib.request.Request(url)

# response : 응답 객체
response = urllib.request.urlopen(request)
print(response)
print('-'*30)

# 응답 객체를 바이트 형태로 바꾼 다음 볼 수 있도록 텍스트로 변환?
# print(response.read()) # utf-8 변환이 안된 아스키코드 상태
# print(response.read().decode('utf-8'))
