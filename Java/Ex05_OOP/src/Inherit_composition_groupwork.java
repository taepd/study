
//조별과제 상속/포함관계 시나리오 만들기


class Coffee {
    int water;
    int coffeeBean;
    
    void roasting() {
        System.out.println("로스팅한다");
    }
    
    Coffee(){
        this(50,5);
    }
    
    Coffee(int water, int coffeeBean){
        this.water=water;
        this.coffeeBean=coffeeBean;
    }
    
}

class Caffelatte extends Coffee {
    Milk milk;
    
    Caffelatte(){
        this(new Milk());
    }
    Caffelatte(Milk milk){
        this.milk = milk;
        
    }
    
}

class Milk {
    String origin;
    String level;
    
    Milk(){
        this("대관령", "1등급");
    }
    Milk(String origin, String level){
        this.origin = origin;
        this.level = level;
    }
}



public class Inherit_composition_groupwork {

    public static void main(String[] args) {
        
        Caffelatte caffelatte = new Caffelatte();
        System.out.println("커피콩의 갯수: "+ caffelatte.coffeeBean);
        System.out.println("물의 양: "+ caffelatte.water);  
        System.out.println("우유 원산지: "+caffelatte.milk.origin+"우유 등급: "+ caffelatte.milk.level);
        caffelatte.roasting();

        
    }

}
