package others.design_pattern.adapter;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The turkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();

    }
}
