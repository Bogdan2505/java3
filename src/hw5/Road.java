package hw5;

import hw5.Car;

public class Road extends Stage {
    int count = 0;

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";

    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
