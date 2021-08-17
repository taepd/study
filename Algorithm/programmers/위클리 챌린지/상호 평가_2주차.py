def solution(scores):
    answer = ''
    for i, v in enumerate(scores):
        if v[i] == (max(v) or min(v)) and v.count(v[i]) > 1:
            v[i](v[i])
        answer += get_grade(sum(v)/len(v))
    return answer

def get_grade(score):
    if score >= 90: return 'A'
    elif score >= 80: return 'B'
    elif score >= 70: return 'C'
    elif score >= 50: return 'D'
    else: return 'F'