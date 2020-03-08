package notleetcode;

import org.junit.Test;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/8 20:57
 */
public class BigDecimal {

    @Test
    public void add() {
        String a = "100001";
        String b = "9999999";
        char[] large = null;
        char[] small = null;
        if (a.length() > b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        int[] sums = new int[large.length + 1];

        for (int i = 0; i < large.length; i++) {
            sums[i] = large[large.length - 1 - i] - '0';

        }
        int temp = 0;
        for (int i = 0; i < small.length; i++) {
            sums[i] += small[small.length - 1 - i] - '0';
            temp = sums[i] / 10;
            sums[i + 1] += temp;
            sums[i] = sums[i] % 10;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = sums.length - 1; i >= 0; i--)
            builder.append(sums[i]);
        String result = sums[sums.length - 1] == 0 ? builder.toString().substring(1) : builder.toString();
        System.out.println(result);
        System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
    }

    @Test
    public void multiple() {
        String a = "9992";
        String b = "99999";
        char[] large = null;
        char[] small = null;
        if (a.length() > b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        int[] result = new int[large.length + small.length];

        for (int j = 0; j < small.length; j++) {
            for (int i = 0; i < large.length; i++) {
                int index = i + j;
                result[index] += ((large[large.length - 1 - i] - '0') * (small[small.length - 1 - j] - '0'));
            }
        }

        for (int i = 0; i < result.length-1; i++) {
            int flag = result[i]/10;
            result[i+1] += flag;
            result[i] %= 10;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--)
            builder.append(result[i]);
        String ans = result[result.length - 1] == 0 ? builder.toString().substring(1) : builder.toString();
        System.out.println(ans);
        System.out.println(Integer.parseInt(a) * Integer.parseInt(b));


    }

}
