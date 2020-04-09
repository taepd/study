package Factory_Method;
public class PizzaFactoryB implements AbstractPizzaFactory{
 
    @Override
    public Pizza createPizza(String name) {
 
        switch (name) {
        case "Tomato": return new TomatoPizza(); 
        case "Cheese":return new CheesePizza();
        }
        return null;
    }
}