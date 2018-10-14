package java;



class Q {
    private int num;
    private boolean valueSet = false;

    synchronized void getNum() throws InterruptedException {
        while (!valueSet) {
            wait();
        }
        System.out.println("Get: " + num);
        valueSet = false;
        notify();
    }

    synchronized void setNum(int num) throws InterruptedException {
        while(valueSet) {
            wait();
        }
        System.out.println("Set: " + num);
        this.num = num;
        valueSet = true;
        notify();
    }
}

class Producer implements Runnable {
    private Q q;

    Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                q.setNum(i++);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Q q;

    Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                q.getNum();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class ProducerConsumer {

    public static void main(String[] args) {
        Q q = new Q();
        Thread t1 = new Thread(new Producer(q));
        Thread t2 = new Thread(new Consumer(q));
        t1.start();
        t2.start();
    }

}
