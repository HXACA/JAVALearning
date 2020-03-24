package TestStrategy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 19:26
 */
public class StrategyA implements Strategy {
    @Override
    public double cost(double num) {
        return num*0.8;
    }
}
