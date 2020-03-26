package decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 10:01
 */
public abstract class Drink {

    public String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
