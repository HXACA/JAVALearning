package TestStrategy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 19:27
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double cost(double num){
        return strategy.cost(num);
    }
}
