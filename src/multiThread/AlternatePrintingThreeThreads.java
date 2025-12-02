package multiThread;

/**
 * 为了改为3个线程交替打印1-100，我们需要对每个线程分配一个打印范围
 * 例如，第一个线程打印3的倍数
 * 第二个线程打印3n+1的数
 * 第三个线程打印3n+2的数（其中n为非负整数）
 * 同时，我们需要一种机制来             确保三个线程能够交替执行
 */
public class AlternatePrintingThreeThreads {
    private int currentNumber=1;//当前要打印的数字
    private static final Object lock=new Object();//用于同步的锁对象
    private int turn=0;//控制哪个线程应该打印的标志 0代表打印3n 1代表打印3n+1 2代表打印3n+2
    public static void main(String[] args) {

        AlternatePrintingThreeThreads ap = new AlternatePrintingThreeThreads();//创建并启动个打印线程
        Thread printer1 = new Thread(() -> ap.printNumbers(0));
        Thread printer2 = new Thread(() -> ap.printNumbers(1));
        Thread printer3 = new Thread(() -> ap.printNumbers(2));
        printer1.start();
        printer2.start();
        printer3.start();
    }
    /**
     * 根据turn的值打印对应范围的数字
     * @param offset 0代表打印3n 1代表打印3n+1 2代表打印3n+2
     */
     private void printNumbers(int offset) {
         while (currentNumber <= 100) {
             synchronized (lock) {
                 while ((turn % 3) != offset) {
                     try {
                         //如果当前线程不应该打印，则等待
                         lock.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 if (currentNumber <= 100 && (currentNumber - 1) % 3 == offset) {
                     System.out.println("Thread " + (offset + 1) + " printed: " + currentNumber);
                     currentNumber++;//打印完一个数字后，将当前数字加1（由打印该数字的线程负责）
                     turn = (turn + 1) % 3;//更新打印标志
                     lock.notifyAll();//唤醒等待中的线程
                 }
             }
         }
     }
}
