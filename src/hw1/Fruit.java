package hw1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Fruit {
    private float weight = 0;

    public Fruit() {
    }

    public float getWeight() {
        return weight;
    }

    public Fruit(float weigh) {
        this.weight = weigh;
    }

}

class Apple extends Fruit {
    public Apple(int weigh) {
        super(weigh * 1.5f);
    }
}

class Orange extends Fruit {
    private float weigh;

    public Orange(int weigh) {
        super(weigh);
    }
    public Orange() {
        super();
        this.weigh = 1.0f;
    }

    public float getSWeight() {
        return weigh;
    }
}

class Box<T extends Fruit> {

    private List<T> boxList = new ArrayList<>();

    public void add(T t) {
        boxList.add(t);
    }

    public int countFruit (){
        return boxList.size();
    }

public List<T> getBoxList(){
        return boxList;
}

    public float getWeight() {
        float result = 0;
        for (T t : boxList) {
            result += t.getWeight();
        }
        return result;
    }

    public boolean compare(Box<?> another) {
        return (this.getWeight() == another.getWeight());
    }

    public void pourOver(Box<T> another) {

        for (int i = 0; i < another.countFruit(); i++) {
            this.add(boxList.get(i));
        }
    }

    public void clear() {
            boxList.clear();
    }

    public  void print() {
        for (T t : boxList) {
            System.out.println(t);

        }
    }

}
