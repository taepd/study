# numpyEx01.py
import numpy as np

data = np.array([[10, 20], [30, 40]])
print(data)
print(data.ndim)

# sum(): 모든 요소의 합
result = np.sum(data)
print(result)
print('-'*30)

# axis=0 행을 따라 sum
result = np.sum(data, axis=0)
print(result)
print('-'*30)

# axis=1 열을 따라 sum
result = np.sum(data, axis=1)
print(result)
print('-'*30)

result = np.mean(data)
print(result)
print('-'*30)

result = np.min(data)
print(result)
print('-'*30)

result = np.max(data)
print(result)
print('-'*30)


print('finished')
