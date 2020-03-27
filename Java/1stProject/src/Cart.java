import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Cart implements Serializable {

    int count;
    int totalprice;
    HashMap<Product, Integer> cartArray;  //Integer는 나의 수량값

    Cart() {
        count = 0;
        totalprice = 0;
        cartArray = new HashMap<Product, Integer>();
    }

    // 카트목록 보여주기
    public void show() {
        count=0;
        Set<Product> set= cartArray.keySet();
        //방법2
        System.out.println("==========================장바구니 리스트==========================");
        System.out.println("       상품명    가격    수량        합산가격              ");
        for(Product p : set) {
    
  
            System.out.printf("%10s %10s %5s %10s",p.getPname(), p.getPrice(), cartArray.get(p), p.getPrice()*cartArray.get(p));
            System.out.println();
            count +=cartArray.get(p);
        }
        
        

        
        System.out.println("총 물건의 개수는 " + count + "입니다.");
        System.out.println("총 가격은 " + totalprice + "입니다.");
    }


    }


