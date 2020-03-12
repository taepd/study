
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

class Product3 {
    int price;
    int bonuspoint;

    Product3() {
        this(100);
    }

    Product3(int price) {
        this.price = price;
        this.bonuspoint = (int) (price / 10.0);
    }

}

class Tv extends Product3 {

    Tv() {
        super(300);
    }

    @Override
    public String toString() {
        return "Tv";
    }

}

class Audio extends Product3 {

    Audio() {
        super(100);
    }

    @Override
    public String toString() {
        return "Audio";
    }

}

class Buyer3 {
    int money;
    int bonusPoint;
    Product3[] cart;
    int index;

    Buyer3() {
        this(10000, 0);
    }

    Buyer3(int money, int bonusPoint) {
        this.money = money;
        this.bonusPoint = bonusPoint;
        cart = new Product3[10];
    }

    void buy(Product3 product) {
        if (this.money < product.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        if (this.index >= 10) {
            System.out.println("더 이상 카트에 담을 수 없습니다.");
            return;
        }
        this.cart[index++] = product;
        this.money -= product.price;
        this.bonusPoint += product.bonuspoint;
        System.out.printf("구입한 상품: %s 제품 가격: %d\n", product.toString(), product.price);
        System.out.println("획득 포인트: " + this.bonusPoint);

    }

    void summary() {
        int totalPrice = 0;
        int totalBonusPoint = 0;
        String productList = "";

        for (int i = 0; i < index; i++) {
            totalPrice += cart[i].price;
            totalBonusPoint += cart[i].bonuspoint;
            productList += cart[i].toString() + " ";

            System.out.println("총 구매 목록: " + productList);
            System.out.println("총 구입 금액: " + totalPrice);
            System.out.println("누적 포인트: " + totalBonusPoint);

        }

    }

}

public class Inherit_Polymorphism_ex {

    public static void main(String[] args) {

        Tv tv = new Tv();
        System.out.println(tv.toString());

        Audio audio = new Audio();
        System.out.println(audio.toString());

        Buyer3 buyer3 = new Buyer3();
        buyer3.buy(tv);
        buyer3.buy(audio);

        buyer3.summary();

    }

}
