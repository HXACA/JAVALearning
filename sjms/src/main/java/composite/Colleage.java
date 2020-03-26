package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 11:08
 */
public class Colleage extends OrganizationComponent {

    List<OrganizationComponent>organizationComponents = new ArrayList<>();

    public Colleage(String name, String des) {
        super(name, des);
    }

    @Override
    public void print() {
        System.out.println(getName());
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }

    @Override
    void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }



}
