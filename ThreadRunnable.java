class CThread implements Runnable {
    int n;

    public CThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
class ThreadRunnable {
    public static void main(String args[]) {
        CThread t1, t2;
        Thread p, q;
        t1 = new CThread(10);
        t2 = new CThread(20);
        p = new Thread(t1);
        q = new Thread(t2);
        System.out.println("Before thread.");
        p.start();
        System.out.println("Between thread.");
        q.start();
        try {
            p.join();
            q.join();
            System.out.println("After thread.");
        } catch (InterruptedException ex) {
            System.out.println("error:" + ex);
        }
    }
}
