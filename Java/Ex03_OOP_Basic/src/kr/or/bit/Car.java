package kr.or.bit;

public class Car {
    private int window;
    private int speed;
    
//  public void writeSpeed(int sp) {
//  speed = sp;
//}
//public int readSpeed() {
//  return speed;
//}

    
    
    
    public int getWindow() {
        return window;
    }
    public void setWindow(int window) {
        this.window = window;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        //간접할당
        if(speed<0) {
         this.speed = 0;
        }else {
        this.speed = speed;
        }
    }
    
    //속도를 10씩 올리거나 감소하는 기능을 만드세요
    
    public void speedUP() {
        speed+=10;
    }
    public void speedDown() {
        if(speed>0) {
            speed-=10;
        }else {
            speed=0;
        }
    }       
    
    
    
    
    
    

    
}
