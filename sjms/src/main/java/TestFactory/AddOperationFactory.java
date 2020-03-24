package TestFactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:47
 */
public class AddOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new AddOperation();
    }
}
