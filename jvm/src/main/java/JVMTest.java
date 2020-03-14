/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/14 22:22
 */
public class JVMTest {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory()/(double)1024/1024);
        System.out.println(Runtime.getRuntime().maxMemory()/(double)1024/1024);
        System.out.println(65024/(double)10752);
        System.out.println(173568/(double)75776);
    }
}
