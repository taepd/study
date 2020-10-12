import tensorflow as tf
import matplotlib.pyplot as plt
from numpy import array, zeros_like


class Cat:
    def show(self):
        image_path = tf.keras.utils.get_file('cat.jpg', 'http://bit.ly/33U6mH9')
        image = plt.imread(image_path)
        titles = ['RGB Image', 'Red channel', 'Green channel', 'Blue channel']
        colors = range(-1, 3)  # <class 'numpy.ndarray'>
        fig, axes = plt.subplots(1, 4, figsize=(13, 3))  # 1행 4열로 13*3으로 서브플롯 생성
        objs = zip(axes, titles, colors)

        for ax, title, color in objs:
            ax.imshow(self.channel(image, color))
            ax.set_title(title)
            ax.set_xticks(())
            ax.set_yticks(())
        plt.show()

    @staticmethod
    def channel(image, color):
        if color not in (0, 1, 2): return image
        c = image[..., color]  # 각 이미지 행렬에서 RGB(012)에 해당하는 열을 행으로 하는 행렬 완성 https://tech.madup.com/python-ellipsis/
        # print(c)
        z = zeros_like(c)
        # print('그냥',[(c, z, z), (z, c, z), (z, z, c)])
        # print('특정 열만', [(c, z, z), (z, c, z), (z, z, c)][color])
        # print('트랜스포즈', array([(c, z, z), (z, c, z), (z, z, c)][color]).transpose(1, 2, 0))  # 다시 원래 형태로 되돌리기


        return array([(c, z, z), (z, c, z), (z, z, c)][color]).transpose(1, 2, 0)

cat= Cat()
cat.show()
