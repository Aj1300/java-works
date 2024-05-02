import java.util.Random;
class Mythread2 extends Thread {
    int r;

    public Mythread2(int random) {
        r = random;
    }

    public void run() {
        int square = r * r;
        System.out.println("Square of : " + r + " = " + square);
    }
}

class Mythread3 extends Thread {
    int r;

    public Mythread3(int random) {
        r = random;
    }

    public void run() {
        int root = r * r * r;
        System.out.println("Root of : " + r + " = " + root);
    }
}

class RanThread extends Thread {

    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int randomInteger = r.nextInt(100);
            System.out.println("Random Integer generated : " + randomInteger);
            if (randomInteger % 2 == 0) {
                Mythread2 m2 = new Mythread2(randomInteger);
                m2.start();
            } else {
                Mythread3 m3 = new Mythread3(randomInteger);
                m3.start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
public class Randomthread {
    public static void main(String args[]) {
        RanThread r = new RanThread();
        r.start();
    }
}

