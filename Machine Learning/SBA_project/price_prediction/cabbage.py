import sys
sys.path.insert(0, 'E:/Dropbox/Dropbox/Programming/Git/Machine Learning/SBA_project')
from util.file_handler import Filereader
import pandas as pd
import numpy as np
import tensorflow as tf
tf.compat.v1.disable_eager_execution()


class Model:
    def __init__(self):
        self.file_reader = Filereader()
    def new_model(self, payload):
        this = self.file_reader
        this.context = 'E:/Dropbox/Dropbox/Programming/Git/Machine Learning/SBA_project/price_prediction/data/'
        this.fname = payload
        return pd.read_csv(this.context + this.fname)
    def create_tf(self, payload):
        xy = np.array(payload, dtype=np.float32)
        x_data = xy[:, 1:-1]  # feature
        y_data = xy[:, [-1]]  # price
        X = tf.compat.v1.placeholder(tf.float32, shape=[None, 4])
        Y = tf.compat.v1.placeholder(tf.float32, shape=[None, 1])
        W = tf.Variable(tf.random.normal([4, 1]), name='weight')
        b = tf.Variable(tf.random.normal([1]), name='bias')
        hypothesis = tf.matmul(X, W) + b
        cost = tf.reduce_mean(tf.square(hypothesis - Y))
        optimizer = tf.compat.v1.train.GradientDescentOptimizer(learning_rate=0.000005)
        train = optimizer.minimize(cost)
        sess = tf.compat.v1.Session()
        sess.run(tf.compat.v1.global_variables_initializer())
        for step in range(100000):
            cost_, hypo_, _ = sess.run([cost, hypothesis, train],
                                       feed_dict={X: x_data, Y: y_data})
            if step % 500 == 0:
                print(f'# {step} 손실비용: {cost_}')
                print(f'- 배추가격 : {hypo_[0]}')
        
        saver = tf.compat.v1.train.Saver()
        print('저장완료')
        


if __name__ == '__main__':
    m = Model()
    dframe = m.new_model('price_data.csv')
    print(dframe.head())
    m.create_tf(dframe)
