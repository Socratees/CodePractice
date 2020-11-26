package others.design_pattern.factorymethod;

public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = creatPizza(type);
        pizza.prepare();

        return pizza;
    }
    protected abstract Pizza creatPizza(String type);
}
