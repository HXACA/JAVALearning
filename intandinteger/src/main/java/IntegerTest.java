/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/8 20:39
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);//如果小于128,并且大于-129,那么时同一个对象，否则不是
        b++;
        System.out.println(a == b);//自增后是一个新对象

        a = 1000;
        b = 1000;
        System.out.println(a==b);//不在缓存范围后，是不同的对象
        System.out.println(a.equals(b));//比较值
        System.out.println(a.intValue() == b.intValue());//拆箱后比较

    }


}
