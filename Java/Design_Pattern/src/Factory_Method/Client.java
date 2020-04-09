package Factory_Method;
public class Client {
 
    public static void main(String[] args) {
    	
        AbstractPizzaFactory pizzaFactory = new PizzaFactoryA();
                  
        Pizza pizza1 = pizzaFactory.createPizza("Tomato");
        Pizza pizza2 = pizzaFactory.createPizza("Pepperoni");
         
        System.out.println(pizza1.getName()+"\n");
        System.out.println(pizza2.getName()+"\n");  
    }
}