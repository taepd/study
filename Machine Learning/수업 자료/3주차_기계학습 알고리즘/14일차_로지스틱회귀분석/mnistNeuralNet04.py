# mnistNeuralNet01.py
from tensorflow.python.keras.datasets import mnist
from keras.utils import to_categorical
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense
import matplotlib.pyplot as plt


image_row, image_col, image_dim = 28, 28, 28*28

(x_train, y_train), (x_test, y_test) = mnist.load_data()
print(x_train[1])
x_train = x_train.reshape(60000, image_dim)
x_train = x_train.astype('float') / 255.0
print(x_train[1])
x_test = x_test.reshape(10000, image_dim)
x_test = x_test.astype('float') / 255.0

# one-hot encoding
y_train = to_categorical(y_train)
y_test = to_categorical(y_test)

print('y_train[0]:', y_train[0])

# 모델 생성
model = Sequential()

# one-hot encoding 이후 이므로 컬럼수로 정답수 계산. np.unique()하면 2 나옴(0,1뿐이므로)
NB_CLASSES = y_train.shape[1]
print('nb: ', NB_CLASSES)
HIDDEN_LAYER_1 = 512
model.add(Dense(units=HIDDEN_LAYER_1, input_shape=(image_dim,), activation='relu'))
model.add(Dense(units=HIDDEN_LAYER_1, activation='relu'))
model.add(Dense(units=NB_CLASSES, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='rmsprop', metrics=['accuracy'])

print('model.fit() 중입니다.')

hist = model.fit(x_train, y_train, validation_split=0.3, epochs=5, batch_size=64, verbose=1)

print('히스토리 목록 보기')
print(hist.history.keys())
print('-'*30)

for key, value in hist.history.items():
    print(f'키: {key}, 값: {value}')


print('-'*30)
print('model.evaluate 실행중')
score = model.evaluate(x_test, y_test, verbose=1)

print(f'test_acc: {score[1]: .4f}')
print('-'*30)

print(f'test_loss: {score[0]: .4f}')
print('-'*30)

# # 모델의 정확도에 대한 히스토리를 시각화
# plt.title('model accuracy')
# plt.xlabel('epoch')
# plt.ylabel('accuracy')
#
# accuracy = hist.history['accuracy']
# val_accuracy = hist.history['val_accuracy']
#
# plt.plot(accuracy)
# plt.plot(val_accuracy)
#
# # plot 이후에 legend 설정해야 한다?
# plt.legend(['train', 'test'], loc='upper left')
#
# filename = 'mnistNeuralNet01_01.png'
# plt.savefig(filename)
# print(filename + ' 파일 저장됨')
#
# # 모델의 손실(비용)함수에 대한 히스토리를 시각화
#
# plt.figure()
# plt.title('model loss')
# plt.xlabel('epoch')
# plt.ylabel('loss')
#
# accuracy = hist.history['loss']
# val_accuracy = hist.history['val_loss']
#
# plt.plot(accuracy)
# plt.plot(val_accuracy)
#
# # plot 이후에 legend 설정해야 한다?
# plt.legend(['train', 'test'], loc='best')
#
# filename = 'mnistNeuralNet01_02.png'
# plt.savefig(filename)
# print(filename + ' 파일 저장됨')