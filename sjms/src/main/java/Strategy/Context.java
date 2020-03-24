package Strategy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 19:21
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void encrypt(){
        strategy.encrypt();
    }
}
