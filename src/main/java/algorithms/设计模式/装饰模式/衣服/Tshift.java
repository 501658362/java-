package algorithms.设计模式.装饰模式.衣服;

import algorithms.设计模式.装饰模式.Finery;
import algorithms.设计模式.装饰模式.Person;

public class Tshift extends Finery {

    public Tshift(Person component) {
        super(component);
    }

    @Override
    public void show() {
        System.out.println("T恤");
        super.show();
    }
}
