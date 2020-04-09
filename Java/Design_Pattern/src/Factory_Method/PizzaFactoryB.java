package Factory_Method;
public class PizzaFactoryB extends AbstractPizzaFactory{
 
    @Override
    public Pizza createPizza(String name) {
 
        switch (name) {
        case "Tomato": return new TomatoPizza(); 
        case "Cheeze":return new CheesePizza();
        }
         
        return null;
    }
      
}