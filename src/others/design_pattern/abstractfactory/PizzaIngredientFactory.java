package others.design_pattern.abstractfactory;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
}
