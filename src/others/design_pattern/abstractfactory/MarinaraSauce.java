package others.design_pattern.abstractfactory;

public class MarinaraSauce implements Sauce {
    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
}
