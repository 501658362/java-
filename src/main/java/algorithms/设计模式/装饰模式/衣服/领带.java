package algorithms.设计模式.装饰模式.衣服;

import algorithms.设计模式.装饰模式.Finery;
import algorithms.设计模式.装饰模式.Person;

public class 领带 extends Finery {

    public 领带(Person component) {
        super(component);
    }

    @Override
    public void show() {

        super.show();
        System.out.println("领带");
    }
}
