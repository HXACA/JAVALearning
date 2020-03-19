package com.xliu.bean;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 16:02
 */
public class Account {

    private Integer id;
    private Float money;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
