package TestFactory;

import java.util.Scanner;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:38
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("第一个操作数");
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        System.out.println("运算符");
        String oper = scanner.nextLine();
        System.out.println("第二个操作数");
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2);

        OperationFactory factory = null;
        Operation operation = null;
        if("+".equals(oper)){
            factory = new AddOperationFactory();
            operation = factory.getOperation();
        }
        operation.setNum1(num1);
        operation.setNum2(num2);

        System.out.println(operation.getResult());

    }
}
