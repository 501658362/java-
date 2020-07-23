package algorithms.设计模式.装饰模式;

import algorithms.设计模式.装饰模式.衣服.休闲裤;
import algorithms.设计模式.装饰模式.衣服.球鞋;
import algorithms.设计模式.装饰模式.衣服.领带;

public class Client {
    public static void main(String[] args) {

        Person person = new Person("陈彦瑾");

        休闲裤 c1 = new 休闲裤(person);
        球鞋 c2 = new 球鞋(c1);

        领带 c3 = new 领带(c2);

        c2.show();
        c3.show();
    }
}
