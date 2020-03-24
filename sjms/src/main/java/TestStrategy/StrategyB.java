package TestStrategy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 19:29
 */
public class StrategyB implements Strategy{
    @Override
    public double cost(double num) {
        return num - Math.floor(num/200) * 50;
    }
}
