package kr.or.bit;

public class NoteBook {
    public String color;
    private int year;
    //private을 쓴 이유: 직접 할당을 막고 간접할당을 통해서 자료를 보호하겠다
    
    public void setYear(int y) {  //간접할당으로 입력받는 인자 범위를 제한함  
        if(y<0) {
            year = 1999;
        }else {
            year = y;            
        }
    }
    
    public int getYear() {
        return year;
    }
    
    public Mouse handle(Mouse m) { //point: m은 Mouse가 들어있는 heap의 주소값이 값이다.
        m.x=100;
        m.y=200;
        return m;
    }

    
    
    
    
    
    
}
