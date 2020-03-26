package composite;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 11:06
 */
public abstract class OrganizationComponent {
    private String name;
    private String des;

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void add(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    void remove(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    public abstract void print();

}
