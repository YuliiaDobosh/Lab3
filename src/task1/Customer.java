package task1;

import java.util.List;

public class Customer {
    private String name;

    public void buyProduct(final Product product) {

    }

    public void buyProducts(final List<Product> products) {

    }

    public Customer() {
    }

    public Customer(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
