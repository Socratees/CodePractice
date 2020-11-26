package others.design_pattern.factorymethod;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza creatPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }
        else if(type.equals("chicago")){
            return new ChicagoStyleCheesePizza();
        }
        else{
            return null;
        }
    }
}
