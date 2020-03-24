package Prototype;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:59
 */
public class MainClass {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("liuxin");
        person1.setAge(20);
        person1.setSex("male");
        System.out.println(person1);
        Person person2 = person1.clone();
        System.out.println(person2);
        System.out.println(person1 == person2);
        person2 = person1;
        System.out.println(person1 == person2);
    }
}
