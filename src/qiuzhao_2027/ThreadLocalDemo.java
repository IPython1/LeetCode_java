package qiuzhao_2027;

/*需求:线程隔离在多线程并发的场景下，每个线程中的变量都是相互独立
        线程A:设置(变量1)获取(变量1)
        线程B:设置(变量2)获取(变量2)
        ThreadLocal
        1.set(）:将变量绑定到当前线程中
        2.get(）:获取当前线程绑定的变量
*/
public class ThreadLocalDemo {

    // 创建一个 ThreadLocal 变量 （将变量绑定到当前线程中）
    // 每个线程访问 THREAD_LOCAL 时，都会拥有自己独立的一份数据
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            // set()：将变量绑定到当前线程中
            THREAD_LOCAL.set("变量1");

            // get()：获取当前线程绑定的变量
            System.out.println(Thread.currentThread().getName()
                    + " 获取：" + THREAD_LOCAL.get());

            // remove()：移除当前线程绑定的变量
            // 在线程池场景下尤其重要，避免线程复用导致数据污染或内存泄漏
            THREAD_LOCAL.remove();
        }, "线程A");

        Thread threadB = new Thread(() -> {
            // set()：将变量绑定到当前线程中
            THREAD_LOCAL.set("变量2");

            // get()：获取当前线程绑定的变量
            System.out.println(Thread.currentThread().getName()
                    + " 获取：" + THREAD_LOCAL.get());

            // remove()：清理当前线程中的变量
            THREAD_LOCAL.remove();
        }, "线程B");

        threadA.start();
        threadB.start();
    }
}
