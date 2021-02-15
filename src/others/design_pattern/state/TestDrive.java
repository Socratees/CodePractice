package others.design_pattern.state;

public class TestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
//        System.out.println(gumballMachine);
    }
}
