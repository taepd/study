package Factory_Method;
public class PizzaFactoryA extends AbstractPizzaFactory{
 
    @Override
    public Pizza createPizza(String name) {
 
        switch (name) {
        case "Tomato": return new TomatoPizza(); 
        case "Pepperoni":return new PepperoniPizza();
        }
         
        return null;
    }
      
}