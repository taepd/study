import os
import sys

sys.path.append(os.path.dirname(os.path.abspath(os.path.dirname(__file__))))
baseurl = os.path.dirname(os.path.abspath(__file__))

import numpy as np
import tensorflow as tf
from tensorflow import keras
from util.version_checker import env_info
from util.file_helper import FileReader


class SaveLoad:
    train_images: object = None
    train_labels: object = None
    test_images: object = None
    test_labels: object = None
    model: object = None
    new_model: object = None

    def __init__(self):
        env_info()
        print(f'baseurl #### {baseurl}')
        self.reader = FileReader()

    def hook(self):
        self.get_data()
        self.create_model()
        self.train_model()
        self.save_model()
        self.load_model()

    def get_data(self):
        (self.train_images, self.train_labels), (self.test_images, self.test_labels) \
            = tf.keras.datasets.mnist.load_data()
        self.train_labels = self.train_labels[:1000]
        self.test_labels = self.test_labels[:1000]

        self.train_images = self.train_images[:1000].reshape(-1, 28 * 28) / 255.0
        self.test_images = self.test_images[:1000].reshape(-1, 28 * 28) / 255.0

    def create_model(self):
        self.model = tf.keras.models.Sequential([
            keras.layers.Dense(512, activation='relu', input_shape=(784,)),
            keras.layers.Dropout(0.2),
            keras.layers.Dense(10, activation='softmax')
        ])

        self.model.compile(optimizer='adam',
                           loss='sparse_categorical_crossentropy',
                           metrics=['accuracy'])

    def train_model(self):
        checkpoint_path = "training_1/cp.ckpt"
        checkpoint_dir = os.path.dirname(checkpoint_path)
        # 모델의 가중치를 저장하는 콜백 만들기
        cp_callback = tf.keras.callbacks.ModelCheckpoint(filepath=checkpoint_path,
                                                         save_weights_only=True,
                                                         verbose=1)

        # 새로운 콜백으로 모델 훈련하기
        self.model.fit(self.train_images,
                       self.train_labels,
                       epochs=10,
                       validation_data=(self.test_images, self.test_labels),
                       callbacks=[cp_callback])  # 콜백을 훈련에 전달합니다
        # 옵티마이저의 상태를 저장하는 것과 관련되어 경고가 발생할 수 있습니다.
        # 이 경고는 (그리고 이 노트북의 다른 비슷한 경고는) 이전 사용 방식을 권장하지 않기 위함이며 무시해도 좋습니다.

        # 모델을 평가합니다(가중치 없이)
        loss, acc = self.model.evaluate(self.test_images, self.test_labels, verbose=2)
        print("훈련되지 않은 모델의 정확도: {:5.2f}%".format(100 * acc))
        # verbose 는 학습 진행상황 보여주는 여부 옵션
        '''
        verbose: Integer. 0, 1, or 2. 
        Verbosity mode. 
        0 = silent, 
        1 = progress bar, 
        2 = one line per epoch.
        '''

        # 가중치 로드
        self.model.load_weights(checkpoint_path)

        # 모델 재평가
        loss, acc = self.model.evaluate(self.test_images, self.test_labels, verbose=2)
        print("복원된 모델의 정확도: {:5.2f}%".format(100 * acc))

        # 파일 이름에 에포크 번호를 포함시킵니다(`str.format` 포맷)
        checkpoint_path = os.path.join(baseurl, "training_2/cp-{epoch:04d}.ckpt")
        checkpoint_dir = os.path.dirname(checkpoint_path)

        # 다섯 번째 에포크마다 가중치를 저장하기 위한 콜백을 만듭니다
        cp_callback = tf.keras.callbacks.ModelCheckpoint(
            filepath=checkpoint_path,
            verbose=1,
            save_weights_only=True,
            period=5)

        # `checkpoint_path` 포맷을 사용하는 가중치를 저장합니다
        self.model.save_weights(checkpoint_path.format(epoch=0))

        # 새로운 콜백을 사용하여 모델을 훈련합니다
        self.model.fit(self.train_images,
                  self.train_labels,
                  epochs=50,
                  callbacks=[cp_callback],
                  validation_data=(self.test_images, self.test_labels),
                  verbose=0)


    def save_model(self):
        # 전체 모델을 HDF5 파일로 저장합니다
        model_dir = './saved_model/'  # 모델을 저장할 폴더
        if not os.path.exists(model_dir):
            os.mkdir(model_dir)
        self.model.save(os.path.join(baseurl, f'{model_dir}my_model.h5'))
        print('============================')

    def load_model(self):
        model_dir = './saved_model/'
        self.new_model = keras.models.load_model(os.path.join(baseurl, f'{model_dir}my_model.h5'))
        self.new_model.summary()
        loss, acc = self.new_model.evaluate(self.test_images, self.test_labels, verbose=2)

    def debug_model(self):
        print(f'모델 정보: {self.model.summary()}')


if __name__ == '__main__':
    api = SaveLoad()
    api.hook()
