package qiuzhao_2027;

public class WithoutThreadLocalDemo {

    // 变量
    private String content;

    private String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        WithoutThreadLocalDemo demo = new WithoutThreadLocalDemo();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /*
                        每个线程：存一个变量，过一会取出这个变量
                        这里没有使用 ThreadLocal，多个线程共享 demo 对象中的 content，
                        所以 content 可能会被其他线程覆盖。
                    */
                    demo.setContent(Thread.currentThread().getName() + "的数据");

                    System.out.println("----------------------");

                    System.out.println(Thread.currentThread().getName()
                            + "--->" + demo.getContent());
                }
            });

            thread.start();
        }
    }
}
