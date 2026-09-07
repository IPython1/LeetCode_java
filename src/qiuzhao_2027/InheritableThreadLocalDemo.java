package qiuzhao_2027;

public class InheritableThreadLocalDemo {

    // InheritableThreadLocal：
    // 可以让子线程继承父线程中保存的变量
    private static final InheritableThreadLocal<String> THREAD_LOCAL =
            new InheritableThreadLocal<>();

    public static void main(String[] args) {

        // 父线程 main 设置变量
        THREAD_LOCAL.set("父线程变量");

        System.out.println(Thread.currentThread().getName()
                + " 获取：" + THREAD_LOCAL.get());

        Thread childThread = new Thread(() -> {
            // 子线程可以获取到父线程设置的变量
            System.out.println(Thread.currentThread().getName()
                    + " 获取：" + THREAD_LOCAL.get());

            // 子线程修改自己的变量
            THREAD_LOCAL.set("子线程变量");

            System.out.println(Thread.currentThread().getName()
                    + " 修改后获取：" + THREAD_LOCAL.get());

            THREAD_LOCAL.remove();
        }, "子线程");

        childThread.start();

        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 子线程修改 ThreadLocal 的值，不会影响父线程
        System.out.println(Thread.currentThread().getName()
                + " 最后获取：" + THREAD_LOCAL.get());

        THREAD_LOCAL.remove();
    }
}
