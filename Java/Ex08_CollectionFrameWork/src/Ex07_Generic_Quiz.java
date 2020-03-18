import java.util.ArrayList;

import kr.or.bit.Emp;
import kr.or.bit.CopyEmp;

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


public class Ex07_Generic_Quiz {

    public static void main(String[] args) {
        //1. Array 배열을 사용해서 cart 만들고 제품을 담으세요(tv, audio, notebook)
        Product[] cart = {new ktTv(),new Audio(), new Notebook()};        
        
        //2. ArrayList를 사용해서 cart를 만들고 제품을 담으세요(tv, audio, notebook)
        //단, generic을 사용하세요
        //제품의 이름을 출력하세요
        
        ArrayList<Product> alist = new ArrayList<Product>();
        alist.add(new ktTv());
        alist.add(new Audio());
        alist.add(new Notebook());
        
        for(Product i : alist) {
            System.out.println(i.toString());
        }
        
        
        
        //3. Emp 클래스를 사용해서 사원 3명을 만드세요
        //단, ArrayList<>를 사용하세요
        ArrayList<Emp> emplist = new ArrayList<Emp>();
        emplist.add(new Emp(1, "똘기", "IT"));
        emplist.add(new Emp(2, "떵이", "IT"));
        emplist.add(new Emp(3, "호치", "IT"));
        
 
        //4. 사원의 정보(사번, 이름, 직종)을 개선된 for문을 사용해서 출력하세요
        //단, toString() 사용 금지
        
        for (Emp p : emplist) {
            System.out.println("사번: "+p.getEmpno()+" 이름: "+p.getEname()+" 직종: "+p.getJob());
        }
        
        //5. 사원의 정보(사번, 이름, 직종)을 일반 for문을 사용해서 출력하세요
        //단, toString() 사용 금지
        
        for (int i = 0; i < emplist.size(); i++) {
            System.out.println("사번: "+emplist.get(i).getEmpno()+" 이름: "+emplist.get(i).getEname()+" 직종: "+emplist.get(i).getJob());
        }
        
        //6. CopyEmp라는 클래스를 만드세요(Emp와 같은데)
        //job member field 대신에
        //private int sal; 로 바꾸어서 만드세요(getter, setter 구현)
        //kr.or.bit.CopyEmp로 하세요
        //ArrayList<> 제네릭 사용해서 사원 3명 만드세요
        //아래 데이터 사용
        //100, "김", 1000
        //200, "이", 2000
        //300, "박", 3000
        
        ArrayList<CopyEmp> blist = new ArrayList<CopyEmp>();
        blist.add(new CopyEmp(100, "김", 1000));
        blist.add(new CopyEmp(200, "이", 2000));
        blist.add(new CopyEmp(300, "박", 3000));
        
        
        //7. 200번 사원의 급여를 5000으로 수정해서 출력하세요(일반 for문 안에서...)
        //set 함수
        for (int i = 0; i < blist.size(); i++) {
            if(blist.get(i).getEmpno()==200) {
                blist.get(i).setsal(5000);
                System.out.println(blist.get(i).toString());
            }
        }
        
      
        //8. 300번 사원의 이름을 "궁금해"로 수정해서 출력하세요(개선된 for문 안에서)
        //set 함수
        
        for(CopyEmp p : blist) {
            if(p.getEmpno()==300) {
                p.setEname("궁금해");
                System.out.println(p.toString());
            }
        }
        
    
        
        

    }

}
