package others.design_pattern.abstractfactory;

public class ThickCrustDough implements Dough {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }
}
