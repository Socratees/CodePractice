package others.design_pattern.strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
//        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
        duck.performQuack();
    }
}
