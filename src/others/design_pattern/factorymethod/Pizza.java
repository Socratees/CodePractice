package others.design_pattern.factorymethod;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;

    ArrayList toppings = new ArrayList();

    void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for(int i = 0; i < toppings.size(); i++){
            System.out.println(" " + toppings.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }
}
