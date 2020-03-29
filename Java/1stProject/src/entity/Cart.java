package entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class Cart implements Serializable {

    int count;
    public int totalprice;
    public HashMap<Product, Integer> cartArray;  //Integer는 나의 수량값

    public Cart() {
        count = 0;
        totalprice = 0;
        cartArray = new HashMap<Product, Integer>();
    }

    public void show() {
        count=0;
        Set<Product> set= cartArray.keySet();
        //방법2
        System.out.println("=============장바구니 리스트===============");
        System.out.println("          상품명          가격          수량       합산가격");
        
        for(Product p : set) {  
            System.out.printf("%10s %7s %7s %10s",p.getPname(), String.format("%,d", p.getPrice()),
            		String.format("%,d",cartArray.get(p)),
            		String.format("%,d",p.getPrice()*cartArray.get(p)));
            System.out.println();
            count +=cartArray.get(p);
        }
    }
}



