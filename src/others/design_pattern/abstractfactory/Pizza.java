package others.design_pattern.abstractfactory;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    abstract void prepare();

    void bake(){
        System.out.println("Bake for 20 minutes");
    }

    void cut(){
        System.out.println("Cutting the pizza into slices");
    }

    void box(){
        System.out.println("Place the pizza in the box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public Sauce getSauce() {
        return sauce;
    }
}
