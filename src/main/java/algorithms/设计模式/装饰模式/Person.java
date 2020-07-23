package algorithms.设计模式.装饰模式;

import lombok.Data;

@Data
public class Person {

    private String name;

    public void show() {
        System.out.println("装扮的" + name);
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
