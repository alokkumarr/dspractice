package threads;

import java.util.concurrent.Executors;

public class PrintEvenOddNumberSequence {

    int counter = 1;
    static int N;

    public void printEvenNumber() {
        int c = 0;
        synchronized (this) {
            while (counter <= N) {
                c++;
                if (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notify();
            }
            System.out.println("T1 Time : " + c);
        }
    }

    public void printOddNumber() {
        int c = 0;
        synchronized (this) {
            while (counter < N) {
                c++;
                if (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notify();
            }
            System.out.println("T1 Time : " + c);
        }
    }

    public static void main(String[] args) {
        PrintEvenOddNumberSequence task = new PrintEvenOddNumberSequence();
        N = 10;
        Thread t1 = new Thread(task::printEvenNumber);
        Thread t2 = new Thread(task::printOddNumber);
        t2.start();
        t1.start();
    }
}
