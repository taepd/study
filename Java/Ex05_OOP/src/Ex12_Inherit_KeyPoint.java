/*
시나리오(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다
A라는 전자제품 매장이 오픈되면 
[클라이언트 요구사항]
가전제품은  제품의 가격 , 제품의 포인트 정보를 공통적으로 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름을 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다(ex: Tv , Audio , Computer)
각각의 전자제품은 다른 가격을 가지고 있다(Tv:5000, Audio:6000 ....)
제품의 포인트는 가격의 10% 적용한다
 
시뮬레이션 시나리오
구매자 : 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다 
예를 들면 : 10만원  , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게되면 가지고 있는 돈은  감소하고 포인트는 올라간다
구매자는 처음 초기 금액을 가질 수 있다
*/

class Buyer{
    int money = 1000;
    int bonusPoint;
    
    //구매행위 (기능)
    //구매행위(잔액, 포인트 정보 갱신)
    //**구매자는 매장의 모든 물건을 구매할 수 있다
    
    //물건이 3개... 구매할 수 있는 기능 3개
    
    //1차 오픈 성공 가정..
    //하와이 휴가 .... ^^
    
    //공식 오픈
    //매장에 제품이 1000개의 다른 제품이 추가(제품 등록: POS 등록 자동화)
    //1000개의 다른 제품이 배치
    //질문
    //1. 매장에서 나머지 997개의 제품을 판매할 수 있을까요? >없다
    // 나머지 997개의 제품을 구매할 수 있는 기능을 만들지 않았음
    //2. 난리 >> 인터넷 >> 개발 서버 접속 >> 휴가 >> 997개의 함수 만들어... 휴가는 end...
    //> 변화에 대응하지 못한 것
    
    //즐거운 휴가를 보내기 위한 방법을 제시하세요
    
        
    //1차 코드
//    void kttvBuy(ktTv n) {  //함수가 제품 객체를 parameter 받아서 (가격, 포인트)
//        if(this.money< n.price) {
//            System.out.println("고객님 잔액이 부족합니다^^! "+this.money);
//            return; //함수 종료 > kttvBuy 탈출 (구매 행위 종류)
//        }
//        
//        //실 구매 행위
//        this.money -= n.price;  //잔액
//        this.bonusPoint += n.bonusPoint;
//        System.out.println("구매한 물건은: "+n.toString());
//    }
//    
//    void audioBuy(Audio n) {  //함수가 제품 객체를 parameter 받아서 (가격, 포인트)
//        if(this.money< n.price) {
//            System.out.println("고객님 잔액이 부족합니다^^! "+this.money);
//            return; //함수 종료 > kttvBuy 탈출 (구매 행위 종류)
//        }
//        
//        //실 구매 행위
//        this.money -= n.price;  //잔액
//        this.bonusPoint += n.bonusPoint;
//        System.out.println("구매한 물건은: "+n.toString());
//    }
//    
//    void notebookBuy(Notebook n) {  //함수가 제품 객체를 parameter 받아서 (가격, 포인트)
//        if(this.money< n.price) {
//            System.out.println("고객님 잔액이 부족합니다^^! "+this.money);
//            return; //함수 종료 > kttvBuy 탈출 (구매 행위 종류)
//        }
//        
//        //실 구매 행위
//        this.money -= n.price;  //잔액
//        this.bonusPoint += n.bonusPoint;
//        System.out.println("구매한 물건은: "+n.toString());
//    }
    
    //2차 코드 개선(리펙토링)
    //[하나의 이름]으로 여러 가지 기능(method overloading)
//    void buy(각 객체 매개변수){}
    
    
    //3차 코드 개선(중복 코드 제거)
    //제품이 추가 되더라도 구매행위는 계속되어야 한다
    //why: 즐거운 휴가를 보내기 위해서
    //하나의 이름으로 ... 반복코드 제거..
    //KEY POINT: 모든 제품은 Product를 상속하고 있다
    //모든 제품의 부모는 Product
    //Product P;
    //Audio audio = new Audio
    //p = new Audio();
    //단 부모는 자신 것만 접근 가능
    //***toString() 자식이 오버라이딩 > 부모타입이 접근해도 자식 오버라이딩을 넘어간다
    
    void buy(Product n) {
        if(this.money< n.price) {
            System.out.println("고객님 잔액이 부족합니다^^! 현재 잔액:"+this.money);
            return; //함수 종료 > kttvBuy 탈출 (구매 행위 종류)
        }
        
        //실 구매 행위
        this.money -= n.price;  //잔액
        this.bonusPoint += n.bonusPoint;  
        System.out.println("구매한 물건은: "+n.toString());
        System.out.println("잔액: "+this.money);
        System.out.println("포인트: "+this.bonusPoint);
    } 
}



class Product{
    int price;
    int bonusPoint;
    
    Product(int price){
        this.price = price;
        this.bonusPoint = (int)(this.price/10.0);
        
    }
    
}

class ktTv extends Product{
    ktTv(){
        super(500);       
    }

    @Override
    public String toString() {
        return "KtTv";
    }     
}

class Audio extends Product{
    Audio(){
        super(100);       
    }

    @Override
    public String toString() {
        return "Audio";
    }     
}

class Notebook extends Product{
    Notebook(){
        super(150);       
    }

    @Override
    public String toString() {
        return "Notebook";
    }     
}


public class Ex12_Inherit_KeyPoint {

	public static void main(String[] args) {
		
	     ktTv kttv = new ktTv();
	     System.out.println(kttv.toString());
	     
	     Audio audio  = new Audio();
         System.out.println(audio.toString());
         
         Notebook notebook = new Notebook();
         System.out.println(notebook.toString());
         
         Buyer buyer = new Buyer(); //고객
         
         //1차 오픈 테스트
         //구매행위
         buyer.buy(kttv);
         buyer.buy(notebook);
         buyer.buy(audio);
         buyer.buy(kttv);
         buyer.buy(kttv);
         

         
         
	    
	    
	    
	    
         
         
         
         
	    
	    
	    
	}

}
