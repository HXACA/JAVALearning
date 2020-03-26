package decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 10:11
 */
public class MainClass {
    public static void main(String[] args) {
        Drink coffee = new BlackCoffee();
        System.out.println(coffee.getDes());
        System.out.println(coffee.cost());
        coffee = new Milk(coffee);
        System.out.println(coffee.getDes());
        System.out.println(coffee.cost());
        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDes());
        System.out.println(coffee.cost());
    }
}
