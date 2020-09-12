new_id = "z-+.^."
import re

def solution(new_id):
    answer = ''

    # 1단계
    new_id = new_id.lower()
    # 2단계
    new_id = re.sub('[^a-zA-Z0-9-_.]', '', new_id)
    # 3단계
    new_id = re.sub('\.{1,}[.]', '.', new_id)
    # 4단계
    new_id = re.sub('^\.|\.$', '', new_id)
    # 5단계
    if new_id == '':
        new_id = 'a'
    # 6단계
    if len(new_id) >= 16:
        new_id = re.sub('\.$', '', new_id[:15])
    # 7단계
    if len(new_id) <= 2:
        while len(new_id) < 3:
            new_id += new_id[-1]

    answer = new_id
    return answer

print(solution(new_id))