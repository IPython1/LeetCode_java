package multiThread;

/**
 * 以下是一个简单的Java双线程程序，其中一个线程打印奇数，另一个线程打印偶数。线程之间通过wait（）和
 * notifyAll（）方法进行协调，以确保它们轮流打印数字。
 */
public class Twothreadsprintfrom1to100 {
    private static int currentNumber=1;//当前要打印的数字
    private static final Object lock=new Object();//用于同步的锁对象
    public static void main(String[] args) {
        Twothreadsprintfrom1to100 ap=new Twothreadsprintfrom1to100();
        //创建并启动打印奇数的线程
        Thread oddPrinter=new Thread(()->ap.printNumbers(true));
        oddPrinter.start();
        //创建并启动打印偶数的线程
        Thread evenPrinter=new Thread(()->ap.printNumbers(false));
        evenPrinter.start();

    }

    /**
     * 根据isOdd标志打印奇数或者偶数
     * @param isOdd true表示打印奇数，false表示打印偶数
     */
    public static void printNumbers(boolean isOdd) {
        while(currentNumber<=100){
            synchronized (lock){
                while((isOdd&&currentNumber%2==0)||(!isOdd&&currentNumber%2==1)){
                    try {
                        lock.wait();//如果当前线程不应该打印 则等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(currentNumber<=100){
                    System.out.println("Thread " + (isOdd ? "odd" : "Even") + " printed: " + currentNumber);
                    currentNumber++;//打印完一个数字后，将当前数字加1
                    lock.notifyAll();//唤醒等待中的线程
                }
            }

        }
    }
}
