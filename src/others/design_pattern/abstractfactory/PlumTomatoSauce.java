package others.design_pattern.abstractfactory;

public class PlumTomatoSauce implements Sauce {
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
}
