package hw4;

import sun.awt.windows.ThemeReader;

public class ABC {
    static final Object mom = new Object();
    static volatile char currentLetter = 'a';
    static int count = 0;

    public static void main(String[] args) {

        while (count != 5) {

            new Thread(() -> {
                try {
                    //    for (int i = 0; i < 5; i++) {
                    synchronized (mom) {
                        while (currentLetter != 'a') {
                            mom.wait();
                        }
                        System.out.println("a");
                        currentLetter = 'b';
                        mom.notify();
                    }
                    //    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    //  for (int i = 0; i < 5; i++) {
                    synchronized (mom) {
                        while (currentLetter != 'b') {
                            mom.wait();
                        }
                        System.out.println("b");
                        currentLetter = 'c';
                        mom.notify();
                    }
                    //    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    //  for (int i = 0; i < 5; i++) {
                    synchronized (mom) {
                        while (currentLetter != 'c') {
                            mom.wait();
                        }
                        System.out.println("c");
                        currentLetter = 'a';
                        mom.notify();
                    }
                    //   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            count++;
        }
    }
}
