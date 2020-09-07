
# 외부 패키지를 사용하는 방법
# import 패키지경로.모듈이름
import somefolder.mymath.mathMod as mathMod

su = 4
result = mathMod.square_root(su)
print(result)

su1 = 2
su2 = 3
result = mathMod.jegob(su1, su2)
print(result)

# 외부 패키지를 사용하는 방법 2
# from 패키지경로.모듈이름 import 함수이름
from somefolder.mymath.mathMod import square_root
su = 3
result = square_root(su)
print(result)


