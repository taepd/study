//두 개의 설계도
class Tv{
    boolean power;
    int chennel;
    void power() {
        this.power = !this.power;
    }
    void chUp() {
        this.chennel++;
        
    }
    void chdown() {
        this.chennel--;
    }
    
}


class Vcr{ //비디오 플레이어
    boolean power;
    void power() {
        this.power = !this.power;
    }
    void play() {
        System.out.println("재생하기");
    }
    void stop() {
        System.out.println("정지하기");
    }
    void rew() {
        
    }
    void ff() {
        
    }
}
// Tv 설계도, Vcr 설계도
// TvVcr 라는 설계도를 만들어 주세요
// 기존에 Tv, Vcr 설계도 잘 이용해봐
// 상속, 포함

//class TvVcr extends Tv, Vcr{} // 다중 상속금지라 안됨
//class Tv extends Vcr
//class TvVcr extend Tv //계층적 상속.. 같은 이름의 기능들이 충돌

//TvVcr 주 기능: 메인 기능 >> 비중이 높은 클래스를 상속받고, 나머지를 포함으로 뺀다

class TvVcr extends Tv{
    Vcr vcr;
    TvVcr(){
        vcr = new Vcr();
    }
}



public class Ex03_Inherit_Single {

    public static void main(String[] args) {
        TvVcr t = new TvVcr();
        t.power();
        System.out.println("Tv 전원 상태: "+t.power);
        t.chUp();
        System.out.println("Tv 채널 상태: "+t.chennel);
        
        //비디오
        t.vcr.power();
        System.out.println("비디오 전원 상태: "+t.vcr.power);
        t.vcr.play();
        t.vcr.stop();
        
        t.vcr.power();
        t.power();
        System.out.println("Tv 전원 상태: "+t.power);
        System.out.println("비디오 전원 상태: "+t.vcr.power);
        
        
        
        
        
        
        
        
        
    }

}
