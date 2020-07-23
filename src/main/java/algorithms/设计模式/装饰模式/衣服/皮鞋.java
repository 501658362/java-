package algorithms.设计模式.装饰模式.衣服;

import algorithms.设计模式.装饰模式.Finery;
import algorithms.设计模式.装饰模式.Person;

public class 皮鞋 extends Finery {

    public 皮鞋(Person component) {
        super(component);
    }

    @Override
    public void show() {
        System.out.println("皮鞋");
        super.show();
    }
}
