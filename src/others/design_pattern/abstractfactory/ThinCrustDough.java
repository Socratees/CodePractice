package others.design_pattern.abstractfactory;

public class ThinCrustDough implements Dough {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }
}
