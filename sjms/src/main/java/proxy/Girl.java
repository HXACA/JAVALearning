package proxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/30 18:43
 */
public class Girl implements Person {
    @Override
    public boolean dating(double length) {
        if(length>1.7){
            return true;
        }else {
            return false;
        }
    }
}
