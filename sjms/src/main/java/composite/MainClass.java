package composite;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 11:13
 */
public class MainClass {
    public static void main(String[] args) {
        University university = new University("ECNU","大学");
        Colleage colleage1 = new Colleage("计算机学院","学院");
        Colleage colleage2 = new Colleage("数学学院","学院");
        university.add(colleage1);
        university.add(colleage2);
        Department department1 = new Department("计算机系","系");
        Department department2 = new Department("软件系","系");
        colleage1.add(department1);
        colleage1.add(department2);
        Department department3 = new Department("数学系","系");
        Department department4 = new Department("应用数学系","系");
        colleage2.add(department3);
        colleage2.add(department4);
        university.print();
    }
}
