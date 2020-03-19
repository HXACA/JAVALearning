import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/19 15:42
 */

class SP{
    private static SP instance = null;

    private SP() {
        System.out.println("构造方法");
    }

    public static SP getInstance() {
        if(instance==null){
            synchronized (SP.class){
                if(instance==null)
                    instance = new SP();
            }
        }
        return instance;
    }
}

class VSP{
    private static final AtomicReference<VSP> INSTANCE = new AtomicReference<>();

    private VSP() {
        System.out.println("构造方法");
    }

    public static VSP getINSTANCE() {
        VSP vsp = INSTANCE.get();
        if(vsp!=null)
            return vsp;
        vsp = new VSP();
        if (INSTANCE.compareAndSet(null,vsp))
            return vsp;
        else
            return getINSTANCE();
    }
}

public class SingletonDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1000, new Runnable() {
            @Override
            public void run() {
                System.out.println("finish");
            }
        });
        for(int i=0;i<1000;i++){
            new Thread(()->{
                VSP s = VSP.getINSTANCE();
                System.out.println(s);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
