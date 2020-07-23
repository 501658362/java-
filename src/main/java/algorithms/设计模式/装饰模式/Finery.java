package algorithms.设计模式.装饰模式;

public class Finery extends Person {

    protected Person component;

    public Finery(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
