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
       int[] nums = new int[10];
    }
}
