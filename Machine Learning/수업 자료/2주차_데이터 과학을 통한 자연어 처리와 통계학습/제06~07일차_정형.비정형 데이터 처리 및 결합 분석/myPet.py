# myPet.py
# Pet 클래스 : 생성자 구현, 함수 구현(sleep(), eat())
class Pet:
    def __init__(self, name, sleeptime, feed='고등어'):
        self.name = name
        self.sleeptime = sleeptime
        self.feed = feed

    def sleep(self):
        pass

    def eat(self):
        pass


romeo = Pet('삽살이', 3, '사료')
romeo.sleep()
romeo.eat()

juliet = Pet('야옹이', 4)
juliet.sleep()
juliet.eat()

print('finished')
