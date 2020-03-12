
/*
문제 풀어 보세요 ^^
요구사항
카트 (Cart)
카트에는 매장에 있는 모든 전자제품을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... 카트에 담는다

계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy())
hint) Buyer ..>> summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
*/
class Product2 {
    int price;
    int bonuspoint;

    // Product2() {}
    Product2(int price) {
        this.price = price;
        this.bonuspoint = (int) (this.price / 10.0);
    }
}

class KtTv2 extends Product2 {
    KtTv2() {
        super(500);
    }

    @Override
    public String toString() {
        return "KtTv2";
    }
}

class Audio2 extends Product2 {
    Audio2() {
        super(100);
    }

    @Override
    public String toString() {
        return "Audio2";  
    }
}

class NoteBook2 extends Product2 {
    NoteBook2() {
        super(150);
    }

    @Override
    public String toString() {
        return "NoteBook2";
    }
}

class Buyer2 { // 구매자
    int money;
    int bonuspoint;
    Product2[] cart; // 카트
    int index;

    Buyer2() {
        this(1000, 0);

    }

    Buyer2(int money, int bonuspoint) {
        this.money = money;
        this.bonuspoint = bonuspoint;
        cart = new Product2[10];
    }

    // 구매기능 안에 장바구니(cart) 넣는 기능 같이 포함하세요
    void Buy(Product2 product) {
        if (this.money < product.price) {
            System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
            return; // 함수종료 > kttvBuy 탈출 (구매 행위 종료)
        }
        // Cart 범위 제한
        if (this.index >= 10) {
            System.out.println("[고객님 그만 사세요]");
            return;
        }
        // 장바구니 담기        
        cart[index++] = product;

        // 실 구매 행위
        this.money -= product.price; // 잔액
        this.bonuspoint += product.bonuspoint; // 누적
        System.out.println("구매한 물건은 : " + product.toString());
        System.out.println("잔액 : " + this.money);
        System.out.println("포인트 : " + this.bonuspoint);

    }

    // 계산대 (장바구니)
    // 장바구니에 담긴 물건을 계산
    // 물건의 총액
    // 물건의 목록 출력
    void Summary() {
//	        for (Product2 p : cart) {             // 물건을 넣지 않은 배열 요소값은 null이여서 java.lang.NullPointerException 에러 발생
                                                  // 즉, null의 세부 요소를 호출하는 격이 되서 오류 발생한 것 (null.toString(),null.price)
//	            System.out.printf("이름: %s, 가격: %d\n",p.toString(),p.price);	           
//	        } System.out.println(1000-money);
        int totalPrice = 0;
        int totalBounsPoint = 0;
        String productList = "";

        for (int i = 0; i < index; i++) { // index 길이(카트에 물건이 넣어진 길이로 제한을 주는게 포인트)
            totalPrice += cart[i].price;
            totalBounsPoint += cart[i].bonuspoint;
            productList += cart[i].toString() + " ";
        }

        System.out.println("*******************");
        System.out.println("구매한 물건 목록: " + productList);
        System.out.println("구매한 물건 총액: " + totalPrice);
        System.out.println("누적 포인트 합계: " + totalBounsPoint);

    }

}

public class Ex13_Inherit_KeyPoint_Override_Array {
    public static void main(String[] args) {

        KtTv2 ktTv2 = new KtTv2();
        Audio2 audio2 = new Audio2();
        NoteBook2 noteBook2 = new NoteBook2();

        Buyer2 buyer2 = new Buyer2();

        buyer2.Buy(noteBook2);
        buyer2.Buy(audio2);
        buyer2.Buy(ktTv2);

        buyer2.Summary();

    }

}
