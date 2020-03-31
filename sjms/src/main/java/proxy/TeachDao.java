package proxy;

import java.util.*;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:07
 */
public class TeachDao implements ITeachDao {
    @Override
    public void teach() {
        ArrayList<Integer>list = new ArrayList<>();
        int[] result = new int[10];
        System.out.println("teach");
    }

    @Override
    public String who(String name) {
        return "I am " + name;
    }

    public static void main(String[] args){
      int a = 1;
      int b = 2;
      double ans = 0;
      double c = (b-a)/2.0;
        System.out.println(c);
    }
}
